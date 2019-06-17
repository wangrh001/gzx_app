package com.bangnd.cbs.web;

import com.bangnd.cbs.entity.CustCredit;
import com.bangnd.cbs.entity.CustMortgage;
import com.bangnd.cbs.entity.Customer;
import com.bangnd.cbs.service.*;
import com.bangnd.ums.entity.User;
import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.util.service.AreaConfService;
import com.bangnd.util.service.StateTypeService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class CustomerController {
    @Resource
    CustomerService customerService;
    @Resource
    CustMortgageService custMortgageService;
    @Resource
    CustCreditService custCreditService;

    @Resource
    AreaConfService areaConfService;
    @Resource
    StateTypeService stateTypeService;
    @Resource
    BankService bankService;

    @Resource
    OrderLogService orderLogService;

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

    /**
     * 将该用户添加到该订单下
     *
     * @param orderId
     * @param customer
     * @param custMortgage
     * @param custCredit
     * @return
     */
    @RequestMapping("/customer/add")
    public String saveCustomer(HttpServletRequest request,
                               String orderId,
                               Customer customer,
                               CustMortgage custMortgage,
                               CustCredit custCredit) {
        int userId = Long.valueOf(((User) request.getSession().getAttribute("user")).getId()).intValue();
        //保存客户信息
        customer.setCustState(1);
        customer.setCreateTime(new Date());
        customer.setCreator(0);
        customer.setOrderId(new Long(orderId).longValue());
        customerService.save(customer);
        orderLogService.recordLog(new Long(orderId).longValue(), userId, ConstantCfg.ORDER_BUTTON_ADDCUST,0,"");
        //保存抵押物信息
        custMortgage.setCreateTime(new Date());
        custMortgage.setCreator(0);
        custMortgage.setCustomerId(customer.getId());
        custMortgageService.save(custMortgage);
        //保存客户征信信息
        custCredit.setCreateTime(new Date());
        custCredit.setCreator(0);
        custCredit.setCustomerId(customer.getId());
        custCreditService.save(custCredit);
        return "redirect:/order/toEdit?orderId=" + orderId;
    }

    @RequestMapping("/customer/delete")
    public String delete(long id) {
        customerService.delete(id);
        Customer customer = customerService.findCustomerById(id);
        String orderId = new Long(customer.getOrderId()).toString();
        return "redirect:/order/toEdit?orderId=" + orderId;
    }

    @RequestMapping("/customer/toModify")
    public String toModify(Model model, long id) {
        Customer customer = customerService.findCustomerById(id);
        CustMortgage custMortgage = custMortgageService.findMortgageByCustomerId(id);
        CustCredit custCredit = custCreditService.findCustCreditByCustomerId(id);
        model.addAttribute("orderId", customer.getOrderId());
        model.addAttribute("customer", customer);
        model.addAttribute("custMortgage", custMortgage);
        model.addAttribute("areaList", areaConfService.getAll());
        model.addAttribute("estateType", stateTypeService.getAll());
        model.addAttribute("banks", bankService.getAll());
        model.addAttribute("custCredit", custCredit);
        return "/cbs/customerEdit";
    }

    @RequestMapping("/customer/modify")
    public String modify(String orderId,
                         Customer customer,
                         CustMortgage custMortgage,
                         CustCredit custCredit) {
        Customer oldCust = customerService.findCustomerById(customer.getId());
        CustMortgage oldCustMortgage = custMortgageService.findMortgageByCustomerId(customer.getId());
        CustCredit oldCustCredit = custCreditService.findCustCreditByCustomerId(customer.getId());

        oldCust.setAddress(customer.getAddress());
        oldCust.setAge(customer.getAge());
        oldCust.setBeStockholderMonths(customer.getBeStockholderMonths());
        oldCust.setBirthday(customer.getBirthday());
        oldCust.setCertiCode(customer.getCertiCode());
        oldCust.setGender(customer.getGender());
        oldCust.setIsNewStockholder(customer.getIsNewStockholder());
        oldCust.setJob(customer.getJob());
        oldCust.setName(customer.getName());
        oldCust.setPhone(customer.getPhone());
        oldCust.setUpdateTime(new Date());
        oldCust.setUpdator(0);
        oldCust.setBankId(customer.getBankId());
        oldCust.setBankCode(customer.getBankCode());
        customerService.save(oldCust);

        oldCustMortgage.setEstateAge(custMortgage.getEstateAge());
        oldCustMortgage.setEstateArea(custMortgage.getEstateArea());
        oldCustMortgage.setEstatePrice(custMortgage.getEstatePrice());
        oldCustMortgage.setEstateType(custMortgage.getEstateType());
        oldCustMortgage.setHouseAddress(custMortgage.getHouseAddress());
        oldCustMortgage.setMortgageType(custMortgage.getMortgageType());
        oldCustMortgage.setUpdateTime(new Date());
        oldCustMortgage.setUpdator(0);
        custMortgageService.save(oldCustMortgage);

        oldCustCredit.setContD2Times2Y(custCredit.getContD2Times2Y());
        oldCustCredit.setContD2Times6M(custCredit.getContD2Times6M());
        oldCustCredit.setContD3Times1Y(custCredit.getContD3Times1Y());
        oldCustCredit.setContD3Times2Y(custCredit.getContD3Times2Y());
        oldCustCredit.setContD3Times5Y(custCredit.getContD3Times5Y());
        oldCustCredit.setContD4Times2Y(custCredit.getContD4Times2Y());
        oldCustCredit.setDDays2Y(custCredit.getDDays2Y());
        oldCustCredit.setDTimes5Y(custCredit.getDTimes5Y());
        oldCustCredit.setDTimes2Y(custCredit.getDTimes2Y());
        oldCustCredit.setDTimes6M(custCredit.getDTimes6M());
        oldCustCredit.setMaxDelay(custCredit.getMaxDelay());
        oldCustCredit.setFreezeAmount(custCredit.getFreezeAmount());
        oldCustCredit.setUpdateTime(new Date());
        oldCustCredit.setUpdator(0);
        custCreditService.save(oldCustCredit);

        return "redirect:/order/toAdd?orderId=" + orderId;
    }
}
