package com.bangnd.bridgecbs.web;

import com.bangnd.bridgecbs.entity.BankAccount;
import com.bangnd.bridgecbs.entity.BridgeOrder;
import com.bangnd.bridgecbs.entity.NewLoanInfo;
import com.bangnd.bridgecbs.service.*;
import com.bangnd.util.service.FormatInfoService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class BridgeNewLoanController {
    @Resource
    private NewLoanInfoService newLoanInfoService;
    @Resource
    private OriginalLoanOrganTypeService originalLoanOrganTypeService;
    @Resource
    private BridgeOrderAcceptionBankCodeService bridgeOrderAcceptionBankCodeService;
    @Resource
    private NewLoanWayService newLoanWayService;
    @Resource
    private NewLoanConditionService newLoanConditionService;
    @Resource
    private BankAccountService bankAccountService;
    @Resource
    private BridgeOrderService bridgeOrderService;
    @Resource
    private FormatInfoService formatInfoService;

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

    @RequestMapping("/bridgecbs/newLoan/add")
    public String addNewLoan(NewLoanInfo newLoanInfo, Long orderId) {
        newLoanInfo.setPassCardBankIdName(bridgeOrderAcceptionBankCodeService.getBridgeOrderAcceptionBankCodeById(newLoanInfo.getPassCardBankId()).getName());
        newLoanInfoService.save(newLoanInfo, orderId);
        BridgeOrder bridgeOrder = bridgeOrderService.getBridgeOrderById(orderId);
        bridgeOrder.setTotalApproveAmount(newLoanInfoService.getTotalApproveAmount(orderId));
        bridgeOrderService.save(bridgeOrder);

        return "redirect:/bridgecbs/bridgeOrder/toModify?id=" + orderId;
    }

    @RequestMapping("/bridgecbs/newLoan/toModify")
    public String toModify(Model model, Long id) {
        try {
            NewLoanInfo newLoanInfo = newLoanInfoService.getOneById(id);
            List<BankAccount> bankAccountsList = bankAccountService.getAllByOrderIdAndType(newLoanInfo.getOrderId(), 4);
            BankAccount bankAccount = new BankAccount();
            model.addAttribute("orderId", id);
            model.addAttribute("bankAccount", bankAccount);
            model.addAttribute("bankAccountsList", bankAccountsList);
            model.addAttribute("newLoanInfo", newLoanInfo);
            model.addAttribute("organTypes", originalLoanOrganTypeService.getAll());
            model.addAttribute("organCodes", bridgeOrderAcceptionBankCodeService.getAll());
            model.addAttribute("loanTypes", newLoanWayService.getAll());
            model.addAttribute("loanConditions", newLoanConditionService.getAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/bridgecbs/newLoanEdit";
    }

    @RequestMapping("/bridgecbs/newLoan/modify")
    public String modify(NewLoanInfo newLoanInfo) {
        NewLoanInfo newLoanInfo1 = newLoanInfoService.getOneById(newLoanInfo.getId());
        newLoanInfo1.setOrganType(newLoanInfo.getOrganType());
        newLoanInfo1.setOrganCode(newLoanInfo.getOrganCode());
        newLoanInfo1.setIfOtherPart(newLoanInfo.getIfOtherPart());
        newLoanInfo1.setApproveAmount(newLoanInfo.getApproveAmount());
        newLoanInfo1.setLoanType(newLoanInfo.getLoanType());
        newLoanInfo1.setLoanCondition(newLoanInfo.getLoanCondition());
        newLoanInfo1.setContactName(newLoanInfo.getContactName());
        newLoanInfo1.setContactPhone(newLoanInfo.getContactPhone());
        newLoanInfo1.setUpdateTime(new Date());

        newLoanInfo1.setPassCardBankId(newLoanInfo.getPassCardBankId());
        newLoanInfo1.setPassCardAccountCode(newLoanInfo.getPassCardAccountCode());
        newLoanInfo1.setPassCardAccountName(newLoanInfo.getPassCardAccountName());
        newLoanInfo1.setPassCardAccountCertiCode(newLoanInfo.getPassCardAccountCertiCode());
        newLoanInfo1.setPassCardAmount(newLoanInfo.getPassCardAmount());
        newLoanInfo1.setPassCardBankIdName(bridgeOrderAcceptionBankCodeService.getBridgeOrderAcceptionBankCodeById(newLoanInfo.getPassCardBankId()).getName());

        newLoanInfoService.merge(newLoanInfo1);
        BridgeOrder bridgeOrder = bridgeOrderService.getBridgeOrderById(newLoanInfo1.getOrderId());
        bridgeOrder.setTotalApproveAmount(newLoanInfoService.getTotalApproveAmount(newLoanInfo1.getOrderId()));
        bridgeOrderService.save(bridgeOrder);
        return "redirect:/bridgecbs/bridgeOrder/toModify?id=" + newLoanInfo1.getOrderId();
    }

    @RequestMapping("/bridgecbs/newLoan/delete")
    public String delete(Long id) {
        NewLoanInfo newLoanInfo = newLoanInfoService.getOneById(id);
        newLoanInfo.setState(100);
        newLoanInfoService.merge(newLoanInfo);
        BridgeOrder bridgeOrder = bridgeOrderService.getBridgeOrderById(newLoanInfo.getOrderId());
        bridgeOrder.setTotalApproveAmount(newLoanInfoService.getTotalApproveAmount(newLoanInfo.getOrderId()));
        bridgeOrderService.save(bridgeOrder);
        return "redirect:/bridgecbs/bridgeOrder/toModify?id=" + newLoanInfo.getOrderId();
    }

}
