package com.bangnd.finance.web;

import com.bangnd.cbs.service.BankService;
import com.bangnd.cbs.service.OrderProductService;
import com.bangnd.finance.entity.Account;
import com.bangnd.finance.entity.Payment;
import com.bangnd.finance.entity.PaymentPayType;
import com.bangnd.finance.form.PaymentSearchForm;
import com.bangnd.finance.service.*;
import com.bangnd.finance.vo.PaymentVO;
import com.bangnd.util.cfg.ConstantCfg;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Resource
    PaymentInOutService paymentInOutService;
    @Resource
    PaymentPayTypeService paymentPayTypeService;
    @Resource
    PaymentPayStateService paymentPayStateService;
    @Resource
    PaymentPayDataTypeService paymentPayDataTypeService;
    @Resource
    BankService bankService;
    @Resource
    OffsetService offsetService;
    @Resource
    AccountService accountService;
    @Resource
    OrderProductService orderProductService;

    /**
     * form表单提交 Date类型数据绑定
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/finance/payment")
    public String home(Model model, @RequestParam(value = "pageNum", required = false) String pageNum, PaymentSearchForm paymentSearchForm) {
        if (pageNum == null) {
            pageNum = "1";
        }
        Page<Payment> pages = paymentService.getPaymentList(Integer.valueOf(pageNum), ConstantCfg.NUM_PER_PAGE, paymentSearchForm);
        model.addAttribute("offsets", offsetService.getAll());
        model.addAttribute("inOuts", paymentInOutService.getAll());
        model.addAttribute("payTypes", paymentPayTypeService.getAll());
        model.addAttribute("payStates", paymentPayStateService.getAll());
        model.addAttribute("ifReals", paymentPayDataTypeService.getAll());
        List<PaymentVO> paymentVOs = new ArrayList<>();
        if (pages != null) {
            for (Payment payment : pages) {
                PaymentVO paymentVO = new PaymentVO();
                paymentVO.setId(payment.getId());
                paymentVO.setOffset(payment.getOffset());
                paymentVO.setAmount(payment.getAmount());
                paymentVO.setPayDate(payment.getPayDate());
                paymentVO.setAccountName(payment.getAccountName());
                paymentVO.setPayTypeName((paymentPayTypeService.getPaymentPayTypeById(payment.getPayType())).getName());
                paymentVOs.add(paymentVO);
            }
        }
        int pagenum = Integer.valueOf(pageNum);
        model.addAttribute("page", pages);
        model.addAttribute("pageNum", pagenum);
        model.addAttribute("totalPages", pages.getTotalPages());
        System.out.println("totalPages=" + pages.getTotalPages());
        model.addAttribute("totalElements", pages.getTotalElements());
        model.addAttribute("paymentVOs", paymentVOs);
        return "/finance/paymentList";
    }

    @RequestMapping("/finance/payment/toAdd")
    public String toAdd(Model model, int id) {
        Payment sorcePayment = paymentService.getPaymentById(id);
        Payment payment = new Payment();
        payment.setRelatedId(id);
        payment.setAccountName(sorcePayment.accountName);
        payment.setAmount(sorcePayment.getAmount());
        model.addAttribute("accounts", accountService.getAll());
        model.addAttribute("payment", payment);
        model.addAttribute("banks", bankService.getAll());
        model.addAttribute("payStates", paymentPayStateService.getAll());
        return "/finance/paymentBusi";
    }

    @RequestMapping("/finance/payment/toAddNoBusi")
    public String toAddNoBusi(Model model) {
        Payment payment = new Payment();
        model.addAttribute("payment", payment);
        model.addAttribute("accounts", accountService.getAll());
        model.addAttribute("banks", bankService.getAll());
        model.addAttribute("payTypes", paymentPayTypeService.getNoBusiFee());
        model.addAttribute("payStates", paymentPayStateService.getAll());
        return "/finance/paymentNoBusi";
    }

    @RequestMapping("/finance/payment/addBusiFee")
    public String addBusiFee(Payment payment) {
        //将原费用核销掉
        Payment sorcePayment = paymentService.getPaymentById(payment.getRelatedId());
        sorcePayment.setOffset(ConstantCfg.OFF_SET_CLOSE);

        PaymentPayType paymentPayType = paymentPayTypeService.getPaymentPayTypeById(sorcePayment.getPayType());
        //设置费用是流入还是流出
        if (paymentPayType.getFeeType() == 1 || paymentPayType.getFeeType() == 3) {
            payment.setInOut(ConstantCfg.IN_OUT_1);
        } else {
            payment.setInOut(ConstantCfg.IN_OUT_2);
        }
        //业务的实收付费用类型对应一个应收付类型
        payment.setPayType(paymentPayType.getRelateId());

        //实收付的状态必须是结束
        payment.setPayState(ConstantCfg.PAY_STATE_FINISHED);

        //设置订单id
        payment.setOrderId(sorcePayment.getOrderId());

        //设置订单产品id
        payment.setOrderProductId(sorcePayment.getOrderProductId());

        //该费用核销掉
        payment.setOffset(ConstantCfg.OFF_SET_CLOSE);
        //是实收付
        payment.setIfReal(ConstantCfg.IFE_REAL_1);

        payment.setState(1);
        payment.setCreator(0);
        payment.setCreateTime(new Date());
        paymentService.save(payment);

        //该产品下所有已经的确认费用都已经核销，订单产品表的状态更新为客户已经支付
        //orderProductService.syncOrderProdState(sorcePayment.getOrderProductId());

        //将原费用的relatedId写成新费用的id
        sorcePayment.setRelatedId(payment.getId());
        paymentService.merge(sorcePayment);
        return "redirect:/finance/payment";
    }

    @RequestMapping("/finance/payment/addNoBusiFee")
    public String addNoBusiFee(Payment payment) {

        PaymentPayType paymentPayType = paymentPayTypeService.getPaymentPayTypeById(payment.getPayType());
        //设置费用是流入还是流出
        if (paymentPayType.getFeeType() == 1 || paymentPayType.getFeeType() == 3) {
            payment.setInOut(ConstantCfg.IN_OUT_1);
        } else {
            payment.setInOut(ConstantCfg.IN_OUT_2);
        }
        //实收付的状态必须是结束
        payment.setPayState(ConstantCfg.PAY_STATE_FINISHED);
        payment.setState(1);
        payment.setCreator(0);
        payment.setCreateTime(new Date());
        //该费用核销掉
        payment.setOffset(ConstantCfg.OFF_SET_CLOSE);
        //是实收付
        payment.setIfReal(ConstantCfg.IFE_REAL_1);
        paymentService.save(payment);
        return "redirect:/finance/payment";
    }

    @RequestMapping("/finance/payment/toModify")
    public String toModify(Model model, Long id) {
        Payment payment = paymentService.getPaymentById(id);
        model.addAttribute("payment", payment);
        model.addAttribute("inOuts", paymentInOutService.getAll());
        model.addAttribute("payTypes", paymentPayTypeService.getAll());
        return "/finance/payment";
    }

    @RequestMapping("/finance/payment/modify")
    public String modify(Payment payment, Long id) {
        Payment oldPayment = paymentService.getPaymentById(id);
        oldPayment.setInOut(payment.getInOut());
        oldPayment.setAmount(payment.getAmount());
        oldPayment.setCompCardNo(payment.getCompCardNo());
        oldPayment.setOtherCardNo(payment.getOtherCardNo());
        oldPayment.setPayType(payment.getPayType());
        oldPayment.setPayDate(payment.getPayDate());
        oldPayment.setAccountName(payment.getAccountName());
        oldPayment.setUpdator(0);
        oldPayment.setUpdateTime(new Date());
        paymentService.merge(oldPayment);
        return "redirect:/finance/payment/toModify?id=" + id;
    }

    @RequestMapping("/finance/payment/delete")
    public String delete(Long id) {
        Payment oldPayment = paymentService.getPaymentById(id);
        oldPayment.setState(100);
        oldPayment.setUpdator(0);
        oldPayment.setUpdateTime(new Date());
        paymentService.merge(oldPayment);
        return "redirect:/finance/payment";
    }
}