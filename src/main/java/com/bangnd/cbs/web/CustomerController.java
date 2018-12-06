package com.bangnd.cbs.web;

import com.bangnd.cbs.entity.CustCredit;
import com.bangnd.cbs.entity.CustMortgage;
import com.bangnd.cbs.entity.Customer;
import com.bangnd.cbs.service.CustCreditService;
import com.bangnd.cbs.service.CustomerService;
import com.bangnd.cbs.service.CustMortgageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;

@Controller
public class CustomerController {
    @Resource
    CustomerService customerService;
    @Resource
    CustMortgageService custMortgageService;
    @Resource
    CustCreditService custCreditService;

    /**
     * 将该用户添加到该订单下
     * @param orderId
     * @param customer
     * @param custMortgage
     * @param custCredit
     * @return
     */
    @RequestMapping("/customer/add")
    public String saveCustomer(String orderId,
                               Customer customer,
                               CustMortgage custMortgage,
                               CustCredit custCredit){
        //保存客户信息
        customer.setCustState(1);
        customer.setCreateTime(new Date());
        customer.setCreator(0);
        customer.setOrderId(new Long(orderId).longValue());
        customerService.save(customer);
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
        return "redirect:/order/toAdd?orderId="+orderId;
    }

    /**
     * 显示该客户的详细信息，需要配置只刷新下面的客户信息
     * @param customerId
     * @return
     */
    @RequestMapping("/customer/showCustDetail")
    public String showCustomerDetail(long customerId,
                                     Model model){
        //根据客户id，获取customer，并放入前端
        Customer customer = customerService.findCustomerById(customerId);
        CustMortgage custMortgage = custMortgageService.findMortgageByCustomerId(customerId);
        CustCredit custCredit = custCreditService.findCustCreditByCustomerId(customerId);
        model.addAttribute("customer",customer);
        model.addAttribute("custMortgage",custMortgage);
        model.addAttribute("custCredit",custCredit);
        return "";
    }

    @RequestMapping("/customer/delete")
    public String  delete(long id){
        customerService.delete(id);
        Customer customer = customerService.findCustomerById(id);
        String orderId=new Long(customer.getOrderId()).toString();
        return "redirect:/order/toAdd?orderId="+orderId;
    }
}
