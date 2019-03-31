package com.bangnd.cbs.web;

import com.bangnd.cbs.entity.*;
import com.bangnd.cbs.form.OrderListForm;
import com.bangnd.cbs.form.OrderProductForm;
import com.bangnd.cbs.form.OrderSearchForm;
import com.bangnd.cbs.service.*;
import com.bangnd.finance.entity.Payment;
import com.bangnd.finance.service.PaymentService;
import com.bangnd.hr.entity.Employee;
import com.bangnd.hr.service.EmployeeService;
import com.bangnd.sales.entity.Agent;
import com.bangnd.sales.entity.Group;
import com.bangnd.sales.entity.PerformanceCommDetail;
import com.bangnd.sales.service.AgentService;
import com.bangnd.sales.service.GroupService;
import com.bangnd.sales.service.PerformanceCommDetailService;
import com.bangnd.sales.service.PerformanceCommissionService;
import com.bangnd.ums.entity.User;
import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.util.entity.WorkFlow;
import com.bangnd.util.service.*;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
    @Resource
    WorkFlowService flowService;
    @Resource
    OrderPoolService orderPoolService;
    @Resource
    WorkFlowService workFlowService;
    @Resource
    EmployeeService employeeService;
    @Resource
    OrganTypeService organTypeService;
    @Resource
    RuleEngineService ruleEngineService;
    @Resource
    PaymentService paymentService;
    @Resource
    PerformanceCommDetailService performanceCommDetailService;
    @Resource
    PerformanceCommissionService performanceCommissionService;
    @Resource
    GroupService groupService;
    /**
     * form表单提交 Date类型数据绑定
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/order")
    public String index() {
        return "redirect:/order/list";
    }

    @RequestMapping("/order/list")
    public String list(Model model,
                       @RequestParam(value="pageNum",required=false) String pageNum,
                       OrderSearchForm orderSearchForm,
                       HttpServletRequest request) {
        long userId=((User)request.getSession().getAttribute("user")).getId();
        List<Long> orderList = orderPoolService.getOrderListString(userId);
        if(orderList!=null&&orderList.size()>0){
            Page<Order> pages = orderService.getOrderList(Integer.valueOf(pageNum==null?"1":pageNum),
                                                      ConstantCfg.NUM_PER_PAGE,
                                                      orderList,
                                                      orderSearchForm);
            List<OrderListForm> orderListForms = new ArrayList<OrderListForm>();
            setReturnObj(pages,model,orderListForms);
        }
        model.addAttribute("pageNum",Integer.valueOf(pageNum==null?"1":pageNum));
        model.addAttribute("businessTypes", businessTypeService.getAll());
        model.addAttribute("orderStates", orderStateService.getAll());
        model.addAttribute("payInterestWays",payInterestWayService.getAll());
        return "/cbs/orderList";
    }

    @RequestMapping("/order/readList")
    public String readList(Model model,
                       @RequestParam(value="pageNum",required=false) String pageNum,
                       OrderSearchForm orderSearchForm) {
        if(orderSearchForm!=null) {
            Page<Order> pages = orderService.getAllOrderList(Integer.valueOf(pageNum == null ? "1" : pageNum),
                    ConstantCfg.NUM_PER_PAGE,
                    orderSearchForm);
            List<OrderListForm> orderListForms = new ArrayList<OrderListForm>();
            setReturnObj(pages, model, orderListForms);
        }
        model.addAttribute("pageNum",Integer.valueOf(pageNum==null?"1":pageNum));
        model.addAttribute("businessTypes", businessTypeService.getAll());
        model.addAttribute("orderStates", orderStateService.getAll());
        model.addAttribute("payInterestWays",payInterestWayService.getAll());
        return "/cbs/orderListRead";
    }

    private void setReturnObj(Page<Order> pages,Model model,List<OrderListForm> orderListForms){
        if (pages != null) {
            for (Order order : pages) {
                OrderListForm orderListForm = new OrderListForm();
                orderListForm.setOrderId(order.getId());
                orderListForm.setApplicantName(order.getApplicantName());
                orderListForm.setAmount(order.getDemandAmount().divide(new BigDecimal(10000)));
                orderListForm.setApplyDate(order.getApplyTime());
                orderListForm.setOrderState((orderStateService.getOrderState(order.getOrderState())).getName());
                OrderPool orderPool = orderPoolService.getHandling(order.getId());
                if(orderPool!=null){
                    long userId=orderPoolService.getHandling(order.getId()).getUserId();
                    Employee employee=employeeService.getEmployeeByUserId(userId);
                    if(employee!=null){
                        orderListForm.setNextHandler(employee.getName());
                    }else {
                        Agent agent = agentService.getAgentByUserId(userId);
                        orderListForm.setNextHandler(agent.getName());
                    }
                }
                orderListForms.add(orderListForm);
            }
        }
        model.addAttribute("page",pages);
        model.addAttribute("totalPages",pages.getTotalPages());
        model.addAttribute("totalElements",pages.getTotalElements());
        model.addAttribute("orderListForms", orderListForms);
    }

    @RequestMapping("/order/toAdd")
    public String toAdd(Model model) {
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
        model.addAttribute("organTypes",organTypeService.getAll());
        model.addAttribute("order", order);
        model.addAttribute("orderProduct", orderProductInit);
        model.addAttribute("customer", customer);
        model.addAttribute("custMortgage", custMortgage);
        model.addAttribute("custCredit", custCredit);
        return "/cbs/orderAdd";
    }

    //添加订单，只保存订单相关属性，客户相关属性在CustomerController中
    @Transactional
    @RequestMapping("/order/add")
    public String saveOrder(HttpServletRequest request,
                            Order order,
                            Integer buttonId){
        long userId=((User)request.getSession().getAttribute("user")).getId();
        Agent agent = agentService.getAgentByUserId(userId);
        if(agent!=null){
            order.setSalerId(Long.valueOf(agent.getId()).intValue());
            order.setChannelType(agent.getChannelType());
        }
        order.setDemandAmount(order.getDemandAmount().multiply(new BigDecimal(10000)));
        order.setApplyTime(new Date());
        order.setCreator(Long.valueOf(userId).intValue());
        order.setCreateTime(new Date());
        if(buttonId==ConstantCfg.BUTTON_ID_71){
            order.setOrderState(ConstantCfg.ORDER_STATE_101);
        }else if(buttonId==ConstantCfg.BUTTON_ID_72){
            order.setOrderState(ConstantCfg.ORDER_STATE_102);
        }
        System.out.println("order.getOrderState="+order.getOrderState());
        System.out.println("buttonId="+buttonId);
        System.out.println("order.getId()="+order.getId());
        try{
            //保存订单
            orderService.save(order);
            //注意，第一进入池中，下一个状态就是order
            orderPoolService.intoPool(order.getId(),0,order.getOrderState(),userId,order.getBusinessType());

        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        orderLogService.recordLog(order.getId(),userId,buttonId);
        return "redirect:/order/list";
    }

    @RequestMapping("/order/toEdit")
    public String toEdit(Model model, Long orderId,HttpServletRequest request) throws Exception{

        Order order =  orderService.findOrderById(orderId);
        order.setDemandAmount(order.getDemandAmount().divide(new BigDecimal(10000)));
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
        model.addAttribute("organTypes",organTypeService.getAll());
        model.addAttribute("order", order);
        model.addAttribute("orderProduct", orderProductInit);
        model.addAttribute("customer", customer);
        model.addAttribute("custMortgage", custMortgage);
        model.addAttribute("custCredit", custCredit);

        int positionId = (Integer)request.getSession().getAttribute("positionId");
        String buttonRes = workFlowService.getButtonRes(order.getOrderState(),positionId,order.getBusinessType());
        System.out.println("buttonRes="+buttonRes);
        model.addAttribute("buttonRes",buttonRes);
        return "/cbs/orderEdit";
    }

    @RequestMapping("/order/read")
    public String read(Model model, Long orderId,HttpServletRequest request) throws Exception {

        Order order = orderService.findOrderById(orderId);
        order.setDemandAmount(order.getDemandAmount().divide(new BigDecimal(10000)));
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
        if (orderProductList != null) {
            setOrderProductForm(orderProductList, orderProductForms);
            model.addAttribute("orderProductForms", orderProductForms);
        }
        model.addAttribute("orderLog", orderLog);
        model.addAttribute("areaList", areaConfService.getAll());
        model.addAttribute("estateType", stateTypeService.getAll());
        model.addAttribute("payWays", payWayService.getAll());
        model.addAttribute("payInterestWays", payInterestWayService.getAll());
        model.addAttribute("businessTypes", businessTypeService.getAll());
        model.addAttribute("productType", productTypeService.getAll());
        model.addAttribute("periodTypes", periodTypeService.getAll());
        model.addAttribute("identityTypes", identityTypeService.getAll());
        model.addAttribute("banks", bankService.getAll());
        model.addAttribute("organTypes", organTypeService.getAll());
        model.addAttribute("order", order);
        model.addAttribute("orderProduct", orderProductInit);
        model.addAttribute("customer", customer);
        model.addAttribute("custMortgage", custMortgage);
        model.addAttribute("custCredit", custCredit);
        //int positionId = (Integer) request.getSession().getAttribute("positionId");
        //String buttonRes = workFlowService.getButtonRes(order.getOrderState(), positionId, order.getBusinessType());
        //System.out.println("buttonRes=" + buttonRes);
        //model.addAttribute("buttonRes", buttonRes);
        return "/cbs/orderRead";
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

    @Transactional
    @RequestMapping("/order/edit")
    public String edit(HttpServletRequest request,
                       Order order,
                       String orderId,
                       Integer buttonId){
        System.out.println("buttonId="+buttonId);
        Order orderOld = orderService.findOrderById(new Long(orderId).longValue());
        long updatorId=((User)request.getSession().getAttribute("user")).getId();
        orderOld.setApplicantName(order.getApplicantName());
        orderOld.setCellPhone(order.getCellPhone());
        orderOld.setBusinessType(order.getBusinessType());
        orderOld.setDemandAmount(order.getDemandAmount().multiply(new BigDecimal(10000)));
        orderOld.setDemandPayWay(order.getDemandPayWay());
        orderOld.setDemandInterest(order.getDemandInterest());
        orderOld.setPeriodType(order.getPeriodType());
        orderOld.setPeriodNum(order.getPeriodNum());
        orderOld.setDemandDate(order.getDemandDate());
        orderOld.setUpdateTime(new Date());
        orderOld.setUpdator(Long.valueOf(updatorId).intValue());
        orderOld.setSignDate(order.getSignDate());
        orderOld.setPayInterestWay(order.getPayInterestWay());
        WorkFlow workFlow = flowService.getNextWorkFlowBy(orderOld.getOrderState(),buttonId,orderOld.getBusinessType());
        orderOld.setOrderState(workFlow.getAfterState());
        if(workFlow.getAfterState()==ConstantCfg.ORDER_STATE_108){
            BigDecimal downFee=ruleEngineService.calc(orderOld.getId(),ConstantCfg.CALC_TYPE_2);
            paymentService.save(setPaymentAttr(orderOld.getId(),downFee,updatorId,ConstantCfg.FEE_TYPE_DOWN));
        }else if(workFlow.getAfterState()==ConstantCfg.ORDER_STATE_116){
            BigDecimal interestFee=ruleEngineService.calc(orderOld.getId(),ConstantCfg.CALC_TYPE_1);
            paymentService.save(setPaymentAttr(orderOld.getId(),interestFee,updatorId,ConstantCfg.FEE_TYPE_INTEREST));
            BigDecimal lawFee=ruleEngineService.calc(orderOld.getId(),ConstantCfg.CALC_TYPE_3);
            paymentService.save(setPaymentAttr(orderOld.getId(),lawFee,updatorId,ConstantCfg.FEE_TYPE_LAWFEE));
        }else if(workFlow.getAfterState()==ConstantCfg.ORDER_STATE_119){
            paymentService.save(setPaymentAttr(orderOld.getId(),orderOld.getDemandAmount(),updatorId,ConstantCfg.FEE_TYPE_OUTAMOUNT));
        }else if(workFlow.getAfterState()==ConstantCfg.ORDER_STATE_124){
            Payment payment = setPaymentAttr(orderOld.getId(),orderOld.getDemandAmount(),updatorId,ConstantCfg.FEE_TYPE_INAMOUNT);
            payment.setInOut(ConstantCfg.IN_OUT_2);
            paymentService.save(payment);
        }else if(workFlow.getAfterState()==ConstantCfg.ORDER_STATE_127){
            Payment payment = paymentService.getPaymentByOrderIdAndFeeType(orderOld.getId(),ConstantCfg.FEE_TYPE_INTEREST);
            if(payment!=null){
                Agent agent = agentService.getAgentById(orderOld.getSalerId());
                //如果是外勤，需要逐笔计算佣金，并写入费用
                if(agent!=null&&agent.getChannelType()==ConstantCfg.CHANNEL_TYPE_2){
                    BigDecimal commission1 = ruleEngineService.calc(orderOld.getId(),ConstantCfg.CALC_TYPE_10);
                    Payment payment1 = setPaymentAttr(orderOld.getId(),commission1,updatorId,ConstantCfg.FEE_TYPE_COMMISSION);
                    payment1.setInOut(ConstantCfg.IN_OUT_2);
                    paymentService.save(payment1);
                    BigDecimal interest = payment.getAmount();
                    PerformanceCommDetail performanceCommDetail = setPerformanceCommDetail(orderOld.getId(),orderOld.getDemandAmount(),interest);
                    performanceCommDetail.setSalerId(orderOld.getSalerId());
                    performanceCommDetail.setMinCommission(commission1);
                    performanceCommDetail.setMaxCommission(commission1);
                    performanceCommDetail.setCommission(commission1);
                    performanceCommDetailService.save(performanceCommDetail);
                }else if(agent!=null&&agent.getChannelType()==ConstantCfg.CHANNEL_TYPE_1){
                    BigDecimal minCommission = ruleEngineService.calc(orderOld.getId(),ConstantCfg.CALC_TYPE_8);
                    BigDecimal commission = ruleEngineService.calc(orderOld.getId(),ConstantCfg.CALC_TYPE_5);
                    BigDecimal maxCommission = ruleEngineService.calc(orderOld.getId(),ConstantCfg.CALC_TYPE_9);
                    BigDecimal interest = payment.getAmount();
                    PerformanceCommDetail performanceCommDetail = setPerformanceCommDetail(orderOld.getId(),orderOld.getDemandAmount(),interest);
                    performanceCommDetail.setSalerId(orderOld.getSalerId());
                    performanceCommDetail.setMinCommission(minCommission);
                    performanceCommDetail.setMaxCommission(maxCommission);
                    performanceCommDetail.setCommission(commission);
                    performanceCommDetailService.save(performanceCommDetail);
                    //回算历史所有佣金明细
                    performanceCommDetailService.reCalc(orderOld.getId());
                    performanceCommissionService.calcMonthCommission(agent.getId(),order.getSignDate());
                }
                //计算经理的提成：
                if(agent!=null){
                    Group group = groupService.getGroupById(agent.getGroupId());
                    if(group!=null){
                        //拿到这个团队的负责人salerId
                        Agent agent1 = agentService.getAgentByEmployeeId(group.getEmployeeId());
                        if(agent1!=null){
                            BigDecimal minCommission = ruleEngineService.calc(orderOld.getId(),ConstantCfg.CALC_TYPE_12);
                            BigDecimal commission = ruleEngineService.calc(orderOld.getId(),ConstantCfg.CALC_TYPE_7);
                            BigDecimal maxCommission = ruleEngineService.calc(orderOld.getId(),ConstantCfg.CALC_TYPE_11);
                            BigDecimal interest = payment.getAmount();
                            PerformanceCommDetail performanceCommDetail = setPerformanceCommDetail(orderOld.getId(),orderOld.getDemandAmount(),interest);
                            performanceCommDetail.setSalerId(agent1.getId());
                            performanceCommDetail.setMinCommission(minCommission);
                            performanceCommDetail.setMaxCommission(maxCommission);
                            performanceCommDetail.setCommission(commission);
                            performanceCommDetailService.save(performanceCommDetail);
                            //暂时不回算：回算历史所有佣金明细
                            //performanceCommDetailService.reCalcManagerComm(agent1.getEmployeeId());
                            performanceCommissionService.calcMonthCommission(agent1.getId(),order.getSignDate());
                        }

                    }

                }

            }
        }
        try{
            orderPoolService.intoPool(new Long(orderId).longValue(),workFlow.getBeforeState(),workFlow.getAfterState(),updatorId,orderOld.getBusinessType());
        }catch (Exception e){
            e.printStackTrace();
        }
        orderLogService.recordLog(new Long(orderId).longValue(),updatorId,buttonId);
        orderService.flush(orderOld);
        return "redirect:/order/toEdit?orderId=" + orderId;
    }
    private Payment setPaymentAttr(long orderId,BigDecimal amount,long updatorId,int feeType){
        Payment payment = new Payment();
        payment.setOrderId(orderId);
        payment.setAmount(amount);
        payment.setRelatedId(0L);
        payment.setPayType(feeType);
        payment.setInOut(1);
        payment.setOffset(2);
        payment.setIfReal(2);
        payment.setState(1);
        payment.setCreator(Long.valueOf(updatorId).intValue());
        payment.setPayState(6);
        payment.setPayDate(new Date());
        return payment;
    }

    private PerformanceCommDetail setPerformanceCommDetail(long orderId,BigDecimal performance,BigDecimal interest){
        PerformanceCommDetail performanceCommDetail = new PerformanceCommDetail();
        performanceCommDetail.setOrderId(orderId);
        performanceCommDetail.setPerformance(performance);
        performanceCommDetail.setInterest(interest);
        performanceCommDetail.setCreateTime(new Date());
        performanceCommDetail.setCreator(0);
        performanceCommDetail.setState(1);
        return performanceCommDetail;
    }
    @RequestMapping("/order/delete")
    public String delete(Long orderId) {
        orderService.delete(orderId);
        return "redirect:/order/list";
    }
}
