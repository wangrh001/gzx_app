package com.bangnd.cbs.web;

import com.bangnd.cbs.entity.CustMortgage;
import com.bangnd.cbs.entity.Customer;
import com.bangnd.cbs.service.CustMortgageService;
import com.bangnd.cbs.service.CustomerService;
import com.bangnd.ums.entity.User;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MortgageController {
    @Resource
    CustomerService customerService;
    @Resource
    CustMortgageService custMortgageService;

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
     * @param custMortgage
     * @return
     */
    @RequestMapping("/mortgage/add")
    public String saveMortgage(HttpServletRequest request,
                               String orderId,
                               CustMortgage custMortgage) {
        int userId = Long.valueOf(((User) request.getSession().getAttribute("user")).getId()).intValue();
        //保存抵押物信息
        custMortgage.setCreateTime(new Date());
        custMortgage.setCreator(userId);
        custMortgage.setOrderId(Long.valueOf(orderId));
        custMortgageService.save(custMortgage);
        return "redirect:/order/toEdit?orderId=" + orderId;
    }

    @RequestMapping("/mortgage/delete")
    public String delete(long id) {
        customerService.delete(id);
        Customer customer = customerService.findCustomerById(id);
        String orderId = new Long(customer.getOrderId()).toString();
        return "redirect:/order/toEdit?orderId=" + orderId;
    }
}
