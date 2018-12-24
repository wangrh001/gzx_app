package com.bangnd.cbs.web;

import com.bangnd.cbs.entity.*;
import com.bangnd.cbs.form.OrderListForm;
import com.bangnd.cbs.form.OrderProductForm;
import com.bangnd.cbs.form.OrderSearchForm;
import com.bangnd.cbs.service.*;
import com.bangnd.util.service.*;
import com.bangnd.util.cfg.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import java.util.Date;
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
    ProductService productService;
    @Resource
    ProductTypeService productTypeService;
    @Resource
    OrderService orderService;
    @Resource
    OrderProductService orderProductService;
    @Resource
    OrderStateService orderStateService;
    @Resource
    BusinessTypeService businessTypeService;
    @Resource
    PeriodTypeService periodTypeService;
    @Resource
    IdentityTypeService identityTypeService;
    @Resource
    OrderProdCustRelationService orderProdCustRelationService;

    @RequestMapping("/order")
    public String index() {
        return "redirect:/order/list";
    }

    @RequestMapping("/order/list")
    public String list(Model model, OrderSearchForm orderSearchForm) {
        List<Order> orders = orderService.getOrderList(orderSearchForm);
        System.out.println("orderListSize="+orders.size());
        model.addAttribute("businessTypes", businessTypeService.getAll());
        model.addAttribute("orderStates", orderStateService.getAll());
        model.addAttribute("orders",orders);
        List<OrderListForm> orderListForms = new ArrayList<OrderListForm>();
        if(orders!=null){
            for(Order order:orders){
                OrderListForm orderListForm = new OrderListForm();
                orderListForm.setOrderId(order.getId());
                orderListForm.setApplicantName(order.getApplicantName());
                orderListForm.setAmount(order.getDemandAmount());
                orderListForm.setApplyDate(order.getApplyTime());
                orderListForm.setOrderState((orderStateService.getOrderState(order.getOrderState())).getName());
                orderListForms.add(orderListForm);
            }
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

    //进入添加订单页面，orderId参数是为了反复进入该页面
    @RequestMapping("/order/toAdd")
    public String toAdd(Model model,Long orderId) {
        System.out.println("enter the toAdd method! orderId="+orderId);
        Order order = new Order();
        OrderProduct orderProductInit = new OrderProduct();
        Customer customer = new Customer();
        CustMortgage custMortgage = new CustMortgage();
        CustCredit custCredit = new CustCredit();
        //不是第一次进入这个界面，比如添加完客户后，再进入该页面，会能查询出客户信息、产品信息
        if(orderId!=null){
            //显示订单下的产品列表
            List<OrderProduct> orderProductList = orderProductService.getOrderProductList(orderId);
            if(null!=orderProductList){
                List<OrderProductForm> orderProductForms= new ArrayList<OrderProductForm>();
                System.out.println("orderProductList size = "+orderProductList.size());
                for (OrderProduct orderProduct:orderProductList) {
                    OrderProductForm orderProductForm = new OrderProductForm();
                    orderProductForm.setId(orderProduct.getId());
                    orderProductForm.setProductName((productService.getProduct(orderProduct.getProductId()).getProductName()));
                    orderProductForm.setBorrowerName((orderProdCustRelationService.findCustomerByOrderProductId(orderProduct.getId(),ConstantCfg.CUSTOMER_IDENTITY_TYPE_1)).getName());
                    orderProductForm.setPlanAmount(orderProduct.getPlanAmount());
                    orderProductForm.setRealAmount(orderProduct.getRealAmount());
                    orderProductForm.setServiceName("");
                    orderProductForm.setStateName((orderStateService.getOrderState(orderProduct.getOrderProdState())).getName());
                    orderProductForm.setApproveTime(orderProduct.getApproveTime());
                    orderProductForms.add(orderProductForm);
                }
                model.addAttribute("orderProductForms", orderProductForms);
            }

            order = orderService.findOrderById(orderId);
            if(order!=null){
                model.addAttribute("products",productService.getProductsByType(order.getBusinessType()));
            }

            //显示订单下所有客户信息
            List<Customer> customerList= customerService.findCustomerByOrderId(orderId);
            if(customerList!=null && customerList.size()>0){
                model.addAttribute("customerList",customerList);
            }
        }
        model.addAttribute("areaList", areaConfService.getAll());
        model.addAttribute("estateType", stateTypeService.getAll());
        model.addAttribute("payWays", payWayService.getAll());
        model.addAttribute("businessTypes", businessTypeService.getAll());
        model.addAttribute("productType", productTypeService.getAll());
        model.addAttribute("periodTypes",periodTypeService.getAll());
        model.addAttribute("identityTypes",identityTypeService.getAll());
        model.addAttribute("order",order);
        model.addAttribute("orderProduct",orderProductInit);
        model.addAttribute("customer", customer);
        model.addAttribute("custMortgage", custMortgage);
        model.addAttribute("custCredit",custCredit);
        return "/order/orderAdd";
    }

    //添加订单，只保存订单相关属性，客户相关属性在CustomerController中
    @RequestMapping("/order/add")
    public String saveOrder(Model model,
                      Order order,
                      String orderId
                      ){
        System.out.println(order.getId());
        Order orderOld=null;
        if(!"".equals(orderId)){
            orderOld= orderService.findOrderById(new Long(orderId).longValue());
        }
        if(orderOld==null){
            order.setApplyTime(new Date());
            //需要设置成用户的销售编号
            order.setAgentId(0);
            //需要设置成用户ID
            order.setCreator(0);
            order.setCreateTime(new Date());
            order.setOrderState(ConstantCfg.ORDER_STATE_INITIAL);
            orderService.save(order);
        }else {
            orderOld.setApplicantName(order.getApplicantName());
            orderOld.setCellPhone(order.getCellPhone());
            orderOld.setBusinessType(order.getBusinessType());
            orderOld.setDemandAmount(order.getDemandAmount());
            orderOld.setDemandPayWay(order.getDemandPayWay());
            orderOld.setDemandInterest(order.getDemandInterest());
            orderOld.setPeriodType(order.getPeriodType());
            orderOld.setPeriodNum(order.getPeriodNum());
            orderOld.setDemandDate(order.getDemandDate());
            orderOld.setUpdateTime(new Date());
            orderService.flush(orderOld);
        }
        return "redirect:/order/toAdd?orderId="+order.getId();
    }

    @RequestMapping("/order/delete")
    public String delete(Long orderId) {
        orderService.delete(orderId);
        return "redirect:/order/list";
    }
}
