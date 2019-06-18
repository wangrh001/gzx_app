package com.bangnd.cbs.web;

import com.bangnd.cbs.entity.*;
import com.bangnd.cbs.form.OrderAllocationForm;
import com.bangnd.cbs.form.OrderListForm;
import com.bangnd.cbs.form.OrderProductForm;
import com.bangnd.cbs.form.OrderSearchForm;
import com.bangnd.cbs.service.*;
import com.bangnd.hr.entity.Action;
import com.bangnd.hr.entity.Dept;
import com.bangnd.hr.entity.Employee;
import com.bangnd.hr.service.DeptService;
import com.bangnd.hr.service.EmployeeService;
import com.bangnd.sales.entity.Agent;
import com.bangnd.sales.service.AgentService;
import com.bangnd.ums.entity.User;
import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.util.entity.FormatInfoObject;
import com.bangnd.util.entity.WorkFlow;
import com.bangnd.util.service.*;
import com.bangnd.util.vo.FormatInfoReturnVO;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
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
    FormatInfoService formatInfoService;
    @Resource
    FormatInfoObjService formatInfoObjService;
    @Resource
    CertificateService certificateService;
    @Resource
    BusinessReminderService businessReminderService;
    @Resource
    DeptService deptService;

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

    @RequestMapping("/order")
    public String index() {
        return "redirect:/order/list";
    }

    @RequestMapping("/order/list")
    public String list(Model model,
                       @RequestParam(value = "pageNum", required = false) String pageNum,
                       OrderSearchForm orderSearchForm,
                       HttpServletRequest request) {
        long userId = ((User) request.getSession().getAttribute("user")).getId();
        List<Long> orderList = orderPoolService.getOrderListString(userId);
        if (orderList != null && orderList.size() > 0) {
            Page<Order> pages = orderService.getOrderList(Integer.valueOf(pageNum == null ? "1" : pageNum),
                    ConstantCfg.NUM_PER_PAGE,
                    orderList,
                    orderSearchForm);
            List<OrderListForm> orderListForms = new ArrayList<OrderListForm>();
            setReturnObj(pages, model, orderListForms);
            model.addAttribute("page", pages);
            model.addAttribute("pageNum", Integer.valueOf(pageNum == null ? "1" : pageNum));
            model.addAttribute("totalPages", pages.getTotalPages());
            model.addAttribute("totalElements", "共" + pages.getTotalElements() + "条");
        }

        model.addAttribute("businessTypes", businessTypeService.getAll());
        model.addAttribute("orderStates", orderStateService.getAll());
        model.addAttribute("payInterestWays", payInterestWayService.getAll());
        return "/cbs/orderList";
    }

    @RequestMapping("/order/readList")
    public String readList(Model model,
                           @RequestParam(value = "pageNum", required = false) String pageNum,
                           OrderSearchForm orderSearchForm) {
        if (orderSearchForm != null) {
            Page<Order> pages = orderService.getAllOrderList(Integer.valueOf(pageNum == null ? "1" : pageNum),
                    ConstantCfg.NUM_PER_PAGE,
                    orderSearchForm);
            List<OrderListForm> orderListForms = new ArrayList<OrderListForm>();
            setReturnObj(pages, model, orderListForms);
        }
        model.addAttribute("pageNum", Integer.valueOf(pageNum == null ? "1" : pageNum));
        model.addAttribute("businessTypes", businessTypeService.getAll());
        model.addAttribute("orderStates", orderStateService.getAll());
        model.addAttribute("payInterestWays", payInterestWayService.getAll());
        return "/cbs/orderListRead";
    }

    private void setReturnObj(Page<Order> pages, Model model, List<OrderListForm> orderListForms) {
        if (pages != null) {
            for (Order order : pages) {
                OrderListForm orderListForm = new OrderListForm();
                orderListForm.setOrderId(order.getId());
                orderListForm.setApplicantName(order.getApplicantName());
                orderListForm.setAmount(order.getLastAmount().divide(new BigDecimal(10000)));
                orderListForm.setDemandDate(order.getDemandDate());
                orderListForm.setOrderState((orderStateService.getOrderState(order.getOrderState())).getName());
                OrderPool orderPool = orderPoolService.getHandling(order.getId());
                if (orderPool != null) {
                    long userId = orderPoolService.getHandling(order.getId()).getUserId();
                    Employee employee = employeeService.getEmployeeByUserId(userId);
                    if (employee != null) {
                        orderListForm.setNextHandler(employee.getName());
                    } else {
                        Agent agent = agentService.getAgentByUserId(userId);
                        orderListForm.setNextHandler(agent.getName());
                    }
                }
                orderListForms.add(orderListForm);
            }
        }
        model.addAttribute("page", pages);
        model.addAttribute("totalPages", pages.getTotalPages());
        model.addAttribute("totalElements", pages.getTotalElements());
        model.addAttribute("orderListForms", orderListForms);
    }

    @RequestMapping("/order/read")
    public String read(Model model, Long orderId, HttpServletRequest request) throws Exception {
        int positionId = (Integer) request.getSession().getAttribute("positionId");
        Order order = orderService.findOrderById(orderId);
        //拿到这个用户可以操作的输入域，拿到的是能看见的，有属性是否可修改，是否必录
        List<FormatInfoReturnVO> formatInfoReturnVOS = formatInfoService.getFormatInfoByUserIdAndStepAndOrderId(order.getBusinessType(), orderId, positionId, order.getOrderState());
        JSONArray jsonArray = new JSONArray();
        transObjListToJSONArray(formatInfoReturnVOS, jsonArray);
        //拿到这个用户可以操作的输入域，拿到的是能看见的，有属性是否可修改，是否必录
        model.addAttribute("formatInfos", jsonArray.toString());
        Agent agent = agentService.getAgentById(order.getSalerId());
        setSalerAndDept(model, agent);
        model.addAttribute("businessTypes", businessTypeService.getAll());
        model.addAttribute("order", order);
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

    @RequestMapping("/order/toAdd")
    public String toAdd(Model model, HttpServletRequest request) throws Exception {
        //long userId = ((User) request.getSession().getAttribute("user")).getId();
        int positionId = (Integer) request.getSession().getAttribute("positionId");
        Order order = new Order();
        OrderProduct orderProductInit = new OrderProduct();
        Customer customer = new Customer();
        CustMortgage custMortgage = new CustMortgage();
        CustCredit custCredit = new CustCredit();
        OrderLog orderLog = new OrderLog();
        FormatInfoObject formatInfoObject = new FormatInfoObject();
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

        List<FormatInfoReturnVO> formatInfoReturnVOS = formatInfoService.getFormatInfoByUserIdAndStepAndOrderId(0, 0L, positionId, 0);
        JSONArray jsonArray = new JSONArray();
        transObjListToJSONArray(formatInfoReturnVOS, jsonArray);
        //拿到这个用户可以操作的输入域，拿到的是能看见的，有属性是否可修改，是否必录
        model.addAttribute("formatInfos", jsonArray.toString());
        model.addAttribute("formatInfoObj", formatInfoObject);

        return "/cbs/orderAdd";
    }

    private void transObjListToJSONArray(List<FormatInfoReturnVO> formatInfoReturnVOS, JSONArray jsonArray) throws JSONException {
        if (formatInfoReturnVOS != null && formatInfoReturnVOS.size() > 0) {
            System.out.println("formatInfoReturnVOS.size()=" + formatInfoReturnVOS.size());
            for (FormatInfoReturnVO formatInfoReturnVO : formatInfoReturnVOS) {
                JSONObject jo = new JSONObject();
                jo.put("chName", formatInfoReturnVO.getChName());
                jo.put("enName", formatInfoReturnVO.getEnName());
                jo.put("dataType", formatInfoReturnVO.getType());
                jo.put("ifScatter", formatInfoReturnVO.getIfScatter());
                jo.put("canModify", formatInfoReturnVO.getCanModify());
                jo.put("needInput", formatInfoReturnVO.getNeedInput());
                jo.put("scatterObj", formatInfoReturnVO.getScatterObj());
                jo.put("dataValue", formatInfoReturnVO.getValue());
                jsonArray.put(jo);
            }
        }
    }

    //添加订单，只保存订单相关属性，客户相关属性在CustomerController中
    @Transactional
    @RequestMapping("/order/add")
    public String saveOrder(HttpServletRequest request,
                            Order order,
                            FormatInfoObject formatInfoObject,
                            Integer buttonId,
                            OrderLog orderLog) {
        long userId = ((User) request.getSession().getAttribute("user")).getId();
        Agent agent = agentService.getAgentByUserId(userId);
        if (agent != null) {
            order.setSalerId(Long.valueOf(agent.getId()).intValue());
            order.setChannelType(agent.getChannelType());
        }
        order.setDemandAmount(order.getDemandAmount().multiply(new BigDecimal(10000)));
        order.setApplyTime(new Date());
        order.setCreator(Long.valueOf(userId).intValue());
        order.setCreateTime(new Date());
        if (buttonId == ConstantCfg.BUTTON_ID_71) {
            order.setOrderState(ConstantCfg.ORDER_STATE_101);
        } else if (buttonId == ConstantCfg.BUTTON_ID_72) {
            order.setOrderState(ConstantCfg.ORDER_STATE_102);
        }
        System.out.println("order.getOrderState=" + order.getOrderState());
        System.out.println("buttonId=" + buttonId);
        System.out.println("order.getId()=" + order.getId());
        try {
            //保存订单
            orderService.save(order);
            //保存订单其他信息
            formatInfoObjService.save(order.getId(),formatInfoObject,userId);
            //注意，第一进入池中，下一个状态就是order
            orderPoolService.intoPool(order.getId(), 0, order.getOrderState(), userId, order.getBusinessType());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        orderLogService.recordLog(order.getId(), userId, buttonId,0,orderLog.getActionDesc());
        return "redirect:/order/list";
    }

    @RequestMapping("/order/toEdit")
    public String toEdit(Model model, Long orderId, HttpServletRequest request) throws Exception {
        int positionId = (Integer) request.getSession().getAttribute("positionId");
        Order order = orderService.findOrderById(orderId);
        Agent agent = agentService.getAgentById(order.getSalerId());
        setSalerAndDept(model, agent);
        CustMortgage custMortgage = new CustMortgage();
        OrderLog orderLog = new OrderLog();
        model.addAttribute("custMortgage", custMortgage);
        model.addAttribute("order", order);
        model.addAttribute("orderLog", orderLog);
        //拿到这个用户可以操作的输入域，拿到的是能看见的，有属性是否可修改，是否必录
        List<FormatInfoReturnVO> formatInfoReturnVOS = formatInfoService.getFormatInfoByUserIdAndStepAndOrderId(order.getBusinessType(), orderId, positionId, order.getOrderState());
        JSONArray jsonArray = new JSONArray();
        transObjListToJSONArray(formatInfoReturnVOS, jsonArray);
        //拿到这个用户可以操作的输入域，拿到的是能看见的，有属性是否可修改，是否必录
        model.addAttribute("formatInfos", jsonArray.toString());

        String buttonRes = workFlowService.getButtonRes(order.getOrderState(), positionId, order.getBusinessType());
        System.out.println("buttonRes=" + buttonRes);
        model.addAttribute("buttonRes", buttonRes);
        return "/cbs/orderEdit";
    }

    private void setSalerAndDept(Model model, Agent agent) {
        if(agent!=null){
            model.addAttribute("agentName", agent.getName());
            Employee employee = employeeService.getEmployeeById(agent.getEmployeeId());
            if(employee!=null){
                Dept dept = deptService.getDeptById(employee.getDept());
                if(dept!=null){
                    model.addAttribute("deptName", dept.getName());
                }
            }
        }
    }

    @Transactional
    @RequestMapping("/order/edit")
    public String edit(HttpServletRequest request,
                       Order order,
                       FormatInfoObject formatInfoObject,
                       String orderId,
                       Integer buttonId,
                       OrderLog orderLog) {
        System.out.println("buttonId=" + buttonId);
        Order orderOld = orderService.findOrderById(new Long(orderId).longValue());
        long updaterId = ((User) request.getSession().getAttribute("user")).getId();

        copyNewOrderToOldOrder(orderOld,order);

        orderOld.setUpdateTime(new Date());
        orderOld.setUpdator(Long.valueOf(updaterId).intValue());
        //根据订单之前状态，加上前端操作按钮，就知道订单之后的状态；
        WorkFlow workFlow = flowService.getNextWorkFlowBy(orderOld.getOrderState(), buttonId, orderOld.getBusinessType());
        orderOld.setOrderState(workFlow.getAfterState());
        //保存订单主要信息
        orderService.flush(orderOld);

        //更新订单其他信息
        FormatInfoObject fio = formatInfoObjService.save(new Long(orderId).longValue(),formatInfoObject,updaterId);

        //根据不同的阶段，写入不同的费用，完结写佣金
        orderService.halderFeeByDiffStep(workFlow.getAfterState(),orderOld,updaterId,fio.getSelfAmount());

        //写日志
        orderLogService.recordLog(new Long(orderId).longValue(), updaterId, buttonId,0,formatInfoObject,orderLog.getActionDesc());
        try {
            //写入池子
            OrderPool orderPool = orderPoolService.intoPool(new Long(orderId).longValue(), workFlow.getBeforeState(), workFlow.getAfterState(), updaterId, orderOld.getBusinessType());

            //再将之后的状态，作为工作流的beforstate，可以拿到下一个的actionid（一个action可以有多个button，比如审批通过、不通过、上报等）
            if(orderOld.getOrderState()!=ConstantCfg.ORDER_STATE_127){
                Action action = flowService.getNextActionByBeforState(new Long(orderId).longValue(),workFlow.getAfterState(),orderOld.getBusinessType());
                //发送消息提醒下一个人：updaterId操作了buttonId，提醒下一个人，该去做action
                businessReminderService.remindNextOperator(updaterId,buttonId,orderPool,action.getName(),orderOld.getApplicantName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //材料已交接：将材料的抵押状态修改为归还状态
        if(orderOld.getOrderState()==ConstantCfg.ORDER_STATE_126){
            certificateService.returnCustomer(orderOld.getId());
        }
        return "redirect:/order/toEdit?orderId=" + orderId;
    }

    private void copyNewOrderToOldOrder(Order orderOld,Order order){
        orderOld.setApplicantName(order.getApplicantName());
        orderOld.setNextAmount(order.getNextAmount());
        orderOld.setLastAmount(order.getLastAmount());
        orderOld.setNextOrgName(order.getNextOrgName());
        orderOld.setLastOrgName(order.getLastOrgName());
        orderOld.setDemandDate(order.getDemandDate());
    }

    @RequestMapping("/order/allocation")
    public String allocation(Model model,
                             @RequestParam(value = "pageNum", required = false) String pageNum,
                             OrderSearchForm orderSearchForm){
        if (orderSearchForm != null) {
            Page<Order> pages = orderService.getAllOrderList(Integer.valueOf(pageNum == null ? "1" : pageNum),
                    ConstantCfg.NUM_PER_PAGE,
                    orderSearchForm);
            List<OrderListForm> orderListForms = new ArrayList<OrderListForm>();
            setReturnObj(pages, model, orderListForms);
        }
        model.addAttribute("pageNum", Integer.valueOf(pageNum == null ? "1" : pageNum));
        model.addAttribute("orderStates", orderStateService.getAll());
        return "/cbs/orderAllocationList";
    }

    @RequestMapping("/order/toModifyHandler")
    public String toModifyHandler(Model model,Long orderId){
        System.out.println("orderId="+orderId);
        OrderPool orderPool = orderPoolService.getHandling(orderId);
        if(orderPool!=null){
            List<Employee> employees = employeeService.getEmployeeByPositionId(orderPool.getPositionId());
            if(employees!=null){
                model.addAttribute("canHandler",employees);
            }
        }
        OrderAllocationForm orderAllocationForm=new OrderAllocationForm();
        orderAllocationForm.setOrderId(orderId);
        //model.addAttribute("orderId",orderId);
        model.addAttribute("orderAllocationForm",orderAllocationForm);
        return "/cbs/orderAllocation";
    }

    @Transactional
    @RequestMapping("/order/modifyHandler")
    public String modifyHandler(Long orderId,Long handler,String desc,HttpServletRequest request){
        System.out.println("orderId="+orderId+"handler="+handler+"desc="+desc);
        long updaterId = ((User) request.getSession().getAttribute("user")).getId();
        Employee employee = employeeService.getEmployeeById(handler);
        if(employee!=null){
            orderPoolService.allocationHandler(employee.getUserId(),orderId);
            orderLogService.recordLog(updaterId,orderId,0,ConstantCfg.ACTION_ALLOCATION_HANDLER,desc);
        }
        return "redirect:/order/allocation";
    }

    @RequestMapping("/order/delete")
    public String delete(Long orderId) {
        orderService.delete(orderId);
        return "redirect:/order/list";
    }

}
