package com.bangnd.bridgecbs.web;

import com.bangnd.bridgecbs.entity.BridgeCustomer;
import com.bangnd.bridgecbs.service.BridgeOrderCertiTypeService;
import com.bangnd.bridgecbs.service.CustRelationTypeService;
import com.bangnd.bridgecbs.service.CustomerService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class BridgeCustomerController {
    @Resource
    private CustomerService customerService;
    @Resource
    private BridgeOrderCertiTypeService bridgeOrderCertiTypeService;
    @Resource
    private CustRelationTypeService custRelationTypeService;

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

    @RequestMapping("/bridgecbs/customer/add")
    public String addCustomer(BridgeCustomer customer, Long orderId, Long mortgageId) {
        customerService.save(customer, orderId, mortgageId);
        return "redirect:/bridgecbs/bridgeOrder/toModify?id=" + orderId;
    }

    @RequestMapping("bridgecbs/customer/toModify")
    public String toModify(Model model, Long id) {
        try {
            BridgeCustomer bridgeCustomer = customerService.getCustomerById(id);
            model.addAttribute("customer", bridgeCustomer);
            model.addAttribute("certiTypes", bridgeOrderCertiTypeService.getAll());
            model.addAttribute("custRelationTypes", custRelationTypeService.getAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/bridgecbs/bridgeCustomerEdit";
    }

    @RequestMapping("bridgecbs/customer/modify")
    public String modify(BridgeCustomer bridgeCustomer) {
        BridgeCustomer bridgeCustomer1 = customerService.getCustomerById(bridgeCustomer.getId());
        bridgeCustomer1.setName(bridgeCustomer.getName());
        bridgeCustomer1.setCertiType(bridgeCustomer.getCertiType());
        bridgeCustomer1.setCustType(bridgeCustomer.getCustType());
        bridgeCustomer1.setCertiCode(bridgeCustomer.getCertiCode());
        bridgeCustomer1.setPhone(bridgeCustomer.getPhone());
        bridgeCustomer1.setUpdateTime(new Date());
        customerService.merge(bridgeCustomer1);
        return "redirect:/bridgecbs/bridgeOrder/toModify?id=" + bridgeCustomer1.getOrderId();
    }

    @RequestMapping("bridgecbs/customer/delete")
    public String delete(Long id) {
        BridgeCustomer bridgeCustomer = customerService.getCustomerById(id);
        bridgeCustomer.setState(100);
        customerService.merge(bridgeCustomer);
        return "redirect:/bridgecbs/bridgeOrder/toModify?id=" + bridgeCustomer.getOrderId();
    }
}
