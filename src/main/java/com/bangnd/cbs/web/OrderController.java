package com.bangnd.cbs.web;

import com.bangnd.cbs.entity.*;
import com.bangnd.cbs.form.OrderListForm;
import com.bangnd.cbs.form.OrderProductForm;
import com.bangnd.cbs.form.OrderSearchForm;
import com.bangnd.cbs.service.*;
import com.bangnd.sales.entity.Agent;
import com.bangnd.sales.service.AgentService;
import com.bangnd.ums.entity.User;
import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.util.security.ResourceStorage;
import com.bangnd.util.service.*;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @Resource
    BankService bankService;
    @Resource
    PayInterestWayService payInterestWayService;
    @Resource
    AgentService agentService;
    @Resource
    OrderLogService orderLogService;

    @RequestMapping("/order")
    public String index() {
        return "redirect:/order/list";
    }

    @RequestMapping("/order/list")
    public String list(Model model,
                       @RequestParam(value="pageNum",required=false) String pageNum,
                       OrderSearchForm orderSearchForm,
                       HttpServletRequest request,
                       HttpSession session) {
        try{
            ResourceStorage.handleResource(request,session);
        }catch (Exception e){
            e.printStackTrace();
        }
        int userId=Long.valueOf(((User)request.getSession().getAttribute("user")).getId()).intValue();
        Page<Order> pages = orderService.getOrderList(Integer.valueOf(pageNum==null?"1":pageNum),
                                                      ConstantCfg.NUM_PER_PAGE,
                                                      (List<Integer>)session.getAttribute("dataRes"),
                                                      orderSearchForm);
        List<OrderListForm> orderListForms = new ArrayList<OrderListForm>();
        if (pages != null) {
            for (Order order : pages) {
                //是否这个用户处理该订单，如果没有处理过，不能显示
                if(!orderLogService.isHandleOrder(order.getId(),userId))
                    continue;
                OrderListForm orderListForm = new OrderListForm();
                orderListForm.setOrderId(order.getId());
                orderListForm.setApplicantName(order.getApplicantName());
                orderListForm.setAmount(order.getDemandAmount());
                orderListForm.setApplyDate(order.getApplyTime());
                orderListForm.setOrderState((orderStateService.getOrderState(order.getOrderState())).getName());
                orderListForms.add(orderListForm);
            }
        }
        model.addAttribute("page",pages);
        model.addAttribute("pageNum",Integer.valueOf(pageNum==null?"1":pageNum));
        model.addAttribute("totalPages",pages.getTotalPages());
        model.addAttribute("totalElements",pages.getTotalElements());

        model.addAttribute("businessTypes", businessTypeService.getAll());
        model.addAttribute("orderStates", orderStateService.getAll());
        model.addAttribute("payInterestWays",payInterestWayService.getAll());
        model.addAttribute("orderListForms", orderListForms);
        return "/cbs/orderList";
    }

    @RequestMapping("/order/toAdd")
    public String toAdd(Model model,HttpServletRequest request) {
        Order order = new Order();
        OrderProduct orderProductInit = new OrderProduct();
        Customer customer = new Customer();
        CustMortgage custMortgage = new CustMortgage();
        CustCredit custCredit = new CustCredit();
        OrderLog orderLog = new OrderLog();
        model.addAttribute("orderLog",orderLog);
        model.addAttribute("areaList", areaConfService.getAll());
        model.addAttribute("estateType", stateTypeService.getAll());
        model.addAttribute("payWays", payWayService.getAll());
        model.addAttribute("payInterestWays",payInterestWayService.getAll());
        model.addAttribute("businessTypes", businessTypeService.getAll());
        model.addAttribute("productType", productTypeService.getAll());
        model.addAttribute("periodTypes", periodTypeService.getAll());
        model.addAttribute("identityTypes", identityTypeService.getAll());
        model.addAttribute("banks", bankService.getAll());
        model.addAttribute("order", order);
        model.addAttribute("orderProduct", orderProductInit);
        model.addAttribute("customer", customer);
        model.addAttribute("custMortgage", custMortgage);
        model.addAttribute("custCredit", custCredit);

        model.addAttribute("buttonRes",request.getSession().getAttribute("buttonRes"));
        return "/cbs/orderAdd";
    }

    //添加订单，只保存订单相关属性，客户相关属性在CustomerController中
    @RequestMapping("/order/add")
    public String saveOrder(HttpServletRequest request,
                            Order order) {
        int userId=Long.valueOf(((User)request.getSession().getAttribute("user")).getId()).intValue();
        Agent agent = agentService.getAgentByUserId(userId);
        order.setApplyTime(new Date());
        order.setAgentId(Long.valueOf(agent.getId()).intValue());
        order.setCreator(userId);
        order.setCreateTime(new Date());
        if(!"".equals(order.getSignDate())&&order.getSignDate()!=null){
            order.setOrderState(ConstantCfg.ORDER_STATE_SIGNED);
        }else {
            order.setOrderState(ConstantCfg.ORDER_STATE_INITIAL);
        }

        try{
            orderService.save(order);
        }catch (Exception e){

        }
        orderLogService.recordLog(order.getId(),userId,ConstantCfg.ORDER_ACTION_1);
        return "redirect:/order/toAdd?orderId=" + order.getId();
    }

    @RequestMapping("/order/toEdit")
    public String toEdit(Model model, Long orderId){
        Order order =  orderService.findOrderById(orderId);
        OrderProduct orderProductInit = new OrderProduct();
        Customer customer = new Customer();
        List<Customer> customerList = customerService.findCustomerByOrderId(orderId);
        List<OrderProduct> orderProductList = orderProductService.getOrderProductList(orderId);
        List<OrderProductForm> orderProductForms = new ArrayList<OrderProductForm>();
        CustMortgage custMortgage = new CustMortgage();
        CustCredit custCredit = new CustCredit();
        OrderLog orderLog = new OrderLog();
        if (order != null) {
            model.addAttribute("products", productService.getProductsByType(order.getBusinessType()));
        }
        //显示订单下所有客户信息
        if (customerList != null && customerList.size() > 0) {
            model.addAttribute("customerList", customerList);
        }
        if (orderProductList!=null) {
            setOrderProductForm(orderProductList, orderProductForms);
            model.addAttribute("orderProductForms", orderProductForms);
        }
        model.addAttribute("orderLog",orderLog);
        model.addAttribute("areaList", areaConfService.getAll());
        model.addAttribute("estateType", stateTypeService.getAll());
        model.addAttribute("payWays", payWayService.getAll());
        model.addAttribute("payInterestWays",payInterestWayService.getAll());
        model.addAttribute("businessTypes", businessTypeService.getAll());
        model.addAttribute("productType", productTypeService.getAll());
        model.addAttribute("periodTypes", periodTypeService.getAll());
        model.addAttribute("identityTypes", identityTypeService.getAll());
        model.addAttribute("banks", bankService.getAll());
        model.addAttribute("order", order);
        model.addAttribute("orderProduct", orderProductInit);
        model.addAttribute("customer", customer);
        model.addAttribute("custMortgage", custMortgage);
        model.addAttribute("custCredit", custCredit);
        return "/cbs/orderEdit";
    }

    private void setOrderProductForm(List<OrderProduct> orderProductList, List<OrderProductForm> orderProductForms) {
        for (OrderProduct orderProduct : orderProductList) {
            OrderProductForm opForm = new OrderProductForm();
            opForm.setId(orderProduct.getId());
            opForm.setProductName((productService.getProductById(orderProduct.getProductId()).getProductName()));
            opForm.setBorrowerName((orderProdCustRelationService.findCustomerByOrderProductId(orderProduct.getId(), ConstantCfg.CUSTOMER_IDENTITY_TYPE_1)).getName());
            opForm.setPlanAmount(orderProduct.getPlanAmount());
            opForm.setRealAmount(orderProduct.getRealAmount());
            opForm.setServiceName("");
            opForm.setStateName((orderStateService.getOrderState(orderProduct.getOrderProdState())).getName());
            opForm.setApproveTime(orderProduct.getApproveTime());
            orderProductForms.add(opForm);
        }
    }

    @RequestMapping("/order/edit")
    public String edit(HttpServletRequest request,
                       Order order,
                       String orderId){
        Order orderOld = orderService.findOrderById(new Long(orderId).longValue());
        int updatorId=Long.valueOf(((User)request.getSession().getAttribute("user")).getId()).intValue();
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
        orderOld.setUpdator(updatorId);
        orderOld.setSignDate(order.getSignDate());
        //如果添加了签约时间，则其订单下的所有产品都是已经签约
        if(!"".equals(order.getSignDate())&&order.getSignDate()!=null){
            orderOld.setOrderState(ConstantCfg.ORDER_STATE_SIGNED);
            orderProductService.updateOrderProductStateByOrderId(orderOld.getId(),ConstantCfg.ORDER_STATE_SIGNED,updatorId);

        }else {
            orderOld.setOrderState(ConstantCfg.ORDER_STATE_INITIAL);
        }
        orderOld.setPayInterestWay(order.getPayInterestWay());
        orderService.flush(orderOld);
        return "redirect:/order/toEdit?orderId=" + orderId;
    }

    @RequestMapping("/order/delete")
    public String delete(Long orderId) {
        orderService.delete(orderId);
        return "redirect:/order/list";
    }
}
