package com.bangnd.cbs.web;

import com.bangnd.cbs.entity.Customer;
import com.bangnd.cbs.entity.CustomerCredit;
import com.bangnd.cbs.entity.Mortgage;
import com.bangnd.cbs.entity.Order;
import com.bangnd.cbs.form.OrderListForm;
import com.bangnd.cbs.form.OrderSearchForm;
import com.bangnd.cbs.service.CustomerCreditService;
import com.bangnd.cbs.service.CustomerService;
import com.bangnd.cbs.service.MortgageService;
import com.bangnd.cbs.service.OrderService;
import com.bangnd.util.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import java.util.List;
import java.util.ArrayList;

@Controller
public class OrderController {
    @Resource
    CustomerService customerService;
    @Resource
    AreaConfService areaConfService;
    @Resource
    StateTypeService stateTypeService;
    @Resource
    PayWayService payWayService;
    @Resource
    ProductTypeService productTypeService;
    @Resource
    MortgageService mortgageService;
    @Resource
    CustomerCreditService customerCreditService;
    @Resource
    OrderService orderService;
    @Resource
    OrderStateService orderStateService;


    @RequestMapping("/order")
    public String index() {
        return "redirect:/order/list";
    }

    @RequestMapping("/order/list")
    public String list(Model model, OrderSearchForm orderSearchForm) {
        List<Order> orders = orderService.getOrderList(orderSearchForm);
        model.addAttribute("productType", productTypeService.getAll());
        model.addAttribute("orderStates", orderStateService.getAll());
        model.addAttribute("orders",orders);
        List<OrderListForm> orderListForms = new ArrayList<OrderListForm>();
        for(int i=0;i<orders.size();i++){
            OrderListForm orderListForm = new OrderListForm();
            orderListForm.setOrderId(orders.get(i).getOrderId());
            orderListForm.setCustomerName(orders.get(i).getBorrowerName());
            orderListForm.setProductTypeName(productTypeService.getObjById(orders.get(i).getProductType()).getName());
            orderListForm.setAmount(orders.get(i).getDemandAmount());
            orderListForm.setApplyDate(orders.get(i).getApplyTime());
            orderListForms.add(orderListForm);
        }
        model.addAttribute("orderListForms",orderListForms);
//        Page<Goods> pages=goodsService.findGoodsNoCriteria(Integer.parseInt(pageNum),20,"commentNum");
//        if(pageNum==null){
//            pageNum="1";
//        }
//        int pagenum=Integer.parseInt(pageNum);
//        model.addAttribute("page",pages);
//        model.addAttribute("pageNum",pagenum);
//        model.addAttribute("totalPages",pages.getTotalPages());
//        model.addAttribute("totalElements",pages.getTotalElements());
//        需要在方法 内加入参数：@RequestParam(value="pageNum") String pageNum
        return "/order/orderList";
    }

    @RequestMapping("/order/toAdd")
    public String toAdd(Model model) {
        System.out.println("enter the toAdd method!");
        Customer customer = new Customer();
        Order order = new Order();
        Mortgage mortgage = new Mortgage();
        CustomerCredit custCredit = new CustomerCredit();
        model.addAttribute("areaList", areaConfService.getAll());
        model.addAttribute("estateType", stateTypeService.getAll());
        model.addAttribute("payWays", payWayService.getAll());
        model.addAttribute("productType", productTypeService.getAll());
        model.addAttribute("customer", customer);
        model.addAttribute("mortgage", mortgage);
        model.addAttribute("order", order);
        model.addAttribute("custCredit",custCredit);
        return "/order/orderAdd";
    }

    @RequestMapping("/order/add")
    public String add(Customer customer,
                      Mortgage mortgage,
                      CustomerCredit custCredit,
                      String payWay,
                      String area,
                      String estateType,
                      String productType,
                      String isMutiLoaner,
                      Order order){
        //保存客户征信信息
        customerCreditService.save(custCredit);
        //保存客户信息
        customer.setStatus("0");
        customer.setCreditId(custCredit.getId());
        customerService.save(customer);
        //保存抵押物信息
        mortgage.setEstateArea(new Integer(area).intValue());
        mortgage.setEstateType(new Integer(estateType).intValue());
        mortgageService.save(mortgage);

        //保存订单上的客户需求
        if("on".equals(isMutiLoaner)){
            order.setIsMutiLoaner("Y");
        }else{
            order.setIsMutiLoaner("N");
        }
        order.setBorrowerName(customer.getName());
        order.setProductType(new Integer(productType).intValue());
        order.setPayWay(new Integer(payWay).intValue());
        order.setBorrowerId(customer.getCustomerId());
        order.setMortgageId(mortgage.getMortgageId());
        order.setOrderState(0);
        orderService.save(order);
        return "redirect:/order/list";
    }

    @RequestMapping("/order/toEdit")
    public String toEdit(Model model,Long id) {
        Order order=orderService.findOrderById(id);
        Customer customer = customerService.findCustomerById(order.getBorrowerId());
        Mortgage mortgage = mortgageService.findMortgageById(order.getMortgageId());
        System.out.println("mortgageType="+mortgage.getEstateType());
        CustomerCredit customerCredit = customerCreditService.findCustCreditById(customer.getCreditId());

        model.addAttribute("areaList", areaConfService.getAll());
        model.addAttribute("estateType", stateTypeService.getAll());
        model.addAttribute("payWays", payWayService.getAll());
        model.addAttribute("productType", productTypeService.getAll());
        model.addAttribute("order", order);
        model.addAttribute("customer", customer);
        model.addAttribute("mortgage", mortgage);
        model.addAttribute("custCredit", customerCredit);
        return "/order/orderAdd";
    }

    @RequestMapping("/order/edit")
    public String edit(Order order,
                       Customer customer,
                       Mortgage mortgage,
                       CustomerCredit customerCredit) {
        customerService.save(customer);
        orderService.save(order);
        mortgageService.save(mortgage);
        customerCreditService.save(customerCredit);
        return "redirect:/order/list";
    }


    @RequestMapping("/order/delete")
    public String delete(Long id) {
        orderService.delete(id);
        return "redirect:/order/list";
    }
}
