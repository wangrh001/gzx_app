package com.bangnd.cbs.web;

import com.bangnd.cbs.entity.TCustomer;
import com.bangnd.cbs.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CustomerController {
    @Resource
    CustomerService customerService;


    @RequestMapping("/customer")
    public String index() {
        return "redirect:/customer/list";
    }

    @RequestMapping("/customer/list")
    public String list(Model model) {
        List<TCustomer> customers=customerService.getCustomerList();
        model.addAttribute("customers", customers);
        return "/customer/customerList";
    }

    @RequestMapping("/customer/toAdd")
    public String toAdd() {
        return "/customer/customerAdd";
    }

    @RequestMapping("/customer/add")
    public String add(TCustomer customer) {
        customerService.save(customer);
        return "redirect:/customer/list";
    }

    @RequestMapping("/customer/toEdit")
    public String toEdit(Model model,Long id) {
        TCustomer customer=customerService.findCustomerById(id);
        model.addAttribute("customer", customer);
        return "/customer/customerEdit";
    }

    @RequestMapping("/customer/edit")
    public String edit(TCustomer customer) {
        customerService.edit(customer);
        return "redirect:/customer/list";
    }


    @RequestMapping("/customer/delete")
    public String delete(Long id) {
        customerService.delete(id);
        return "redirect:/customer/list";
    }
}
