package com.bangnd.batch.jobs.cbs;

import com.bangnd.cbs.entity.Order;
import com.bangnd.cbs.service.OrderLogService;
import com.bangnd.cbs.service.OrderService;
import com.bangnd.gw.DingDingGWService;
import com.bangnd.hr.entity.Employee;
import com.bangnd.hr.service.EmployeeService;
import com.bangnd.sales.entity.Agent;
import com.bangnd.sales.service.AgentService;
import com.bangnd.ums.entity.User;
import com.bangnd.ums.service.ResourceService;
import com.bangnd.ums.service.UserService;
import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.util.entity.Reminder;
import com.bangnd.util.entity.ReminderLog;
import com.bangnd.util.service.ParamEngineService;
import com.bangnd.util.service.ReminderLogService;
import com.bangnd.util.service.ReminderService;
import com.bangnd.util.string.StringUtil;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.*;

@Service
public class ReminderJob {

    @Autowired
    UserService userService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    AgentService agentService;
    @Autowired
    ResourceService resourceService;
    @Autowired
    ReminderService reminderService;
    @Autowired
    OrderService orderService;
    @Autowired
    ReminderLogService reminderLogService;
    @Autowired
    ApplicationContext ctx;
    @Autowired
    ParamEngineService paramEngineService;
    @Autowired
    OrderLogService orderLogService;
    @Autowired
    DingDingGWService dingDingGWService;

    /**
     * 遍历所有非完成和非关闭的订单，进行发送通知
     * @throws Exception
     */
    public void process() {
        try{
            System.out.println("enter the reminder Job");
            List<Order> orders = orderService.getNotFinishOrders();
            if(orders!=null && orders.size()>0){
                for(Order order:orders){
                    List<Reminder> reminders = reminderService.getAll();
                    if(reminders!=null && reminders.size()>0){
                        for(Reminder reminder:reminders){
                            //该订单对于该类型需要发
                            if(ifNeedSend(reminder,order.getId())){
                                //生成所有发送人
                                Map<String,String> receiverMap = generateRecieverMap(reminder.getPositions(),order.getId());
                                if(receiverMap!=null && receiverMap.size()>0){
                                    for(String receiverDDname:receiverMap.keySet()){
                                        //针对每一个发送人，生成发送内容，并发送出去
                                        String sayWhat=generateSayWhat(reminder.getSayWhat(),receiverMap.get(receiverDDname),order.getId());
                                        dingDingGWService.sendMessage(receiverDDname,sayWhat);

                                        //存储提醒日志
                                        ReminderLog reminderLog = new ReminderLog();
                                        reminderLog.setOrderId(order.getId());
                                        reminderLog.setUsers(receiverDDname);
                                        reminderLog.setReminderId(reminder.getId());
                                        reminderLog.setWay(reminder.getWay());
                                        reminderLog.setSayWhat(sayWhat);
                                        reminderLog.setState(ConstantCfg.STATE_1);
                                        reminderLog.setCreateTime(new Date());
                                        reminderLog.setCreator(0);
                                        reminderLog.setUpdator(0);
                                        reminderLogService.save(reminderLog);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("提醒批处理执行错误，请检查！");
        }
    }

    /**
     * 判断该订单是否满足发送规则
     * @param reminder
     * @param orderId
     * @return
     * @throws Exception
     */
    private boolean ifNeedSend(Reminder reminder,long orderId) throws Exception {
        boolean flag = false;
        Expression expression = AviatorEvaluator.compile(reminder.getLogicCondition());
        List<String> params = expression.getVariableNames();
        Map<String, Object> env = new HashMap<String, Object>();
        Class clazz = Class.forName("com.bangnd.util.service.impl.ParamEngineServiceImpl");
        if (params != null && params.size() > 0) {
            for (String param : params) {
                Object obj = ctx.getBean(clazz);
                //关键时间点提醒类
                if(reminder.getType()==1&&param.contains("Days")){
                    String keyTime="";
                    String earlier="";
                    if(param.contains("Minus")){
                        int index = param.indexOf("Minus");
                        keyTime = param.substring(0,index);
                        earlier = "-"+param.substring(index+5,index+6);
                    }else if(param.contains("Add")){
                        int index = param.indexOf("Add");
                        keyTime = param.substring(0,index);
                        earlier = param.substring(index+3,index+4);
                    }
                    Method method = obj.getClass().getMethod("getKeyTiming",new Class[]{String.class,String.class,long.class});
                    env.put(param, method.invoke(obj, new Object[]{keyTime,earlier,orderId}));
                }else {
                    String methodName = paramEngineService.getMethodName(param);
                    Method method = obj.getClass().getMethod(methodName,new Class[]{long.class,long.class});
                    env.put(param, method.invoke(obj, new Object[]{reminder.getId(),orderId}));
                }
            }
            Object result = (Object) expression.execute(env);
            if (result instanceof Long) {
                Long resultLong = (Long) result;
                System.out.println(" Long  result=" + resultLong);
                if(resultLong==1L){
                    flag=true;
                }
            }
        }
        return flag;
    }

    /**
     * 把模版中的参数换成实际值返回
     * @param model
     * @param sender
     * @param orderId
     * @return
     * @throws Exception
     */
    private String generateSayWhat(String model,String sender,long orderId) throws Exception {
        List<String> paras=StringUtil.drowPara(model);
        Class clazz = Class.forName("com.bangnd.util.service.impl.ParamEngineServiceImpl");
        if(paras!=null && paras.size()>0){
            for(String param:paras){
                Object obj = ctx.getBean(clazz);
                String methodName = paramEngineService.getMethodName(param);
                Method method = obj.getClass().getMethod(methodName,new Class[]{String.class,String.class});
                String result= (String)method.invoke(obj,new Object[]{sender,String.valueOf(orderId)});
                System.out.println(param+"==:"+result);
                model=model.replaceAll(param,result).replaceAll("\\{","").replaceAll("}","");
            }
        }
        return model;
    }

    /**
     * 根据要给哪些岗位发送通知，返回所有钉钉用户列表
     * @param positionIds
     * @param orderId
     * @return
     */
    private Map<String,String> generateRecieverMap(String positionIds,long orderId){
        Map<String,String> receiverMap= new HashMap<>();
        String[] positionArray = positionIds.trim().split(",");
        List<Long> userIds = orderLogService.getAllLogByOrderId(orderId);
        if(userIds!=null && userIds.size()>0){
            for(Long userId:userIds){
                Agent agent = agentService.getAgentByUserId(userId.longValue());
                //这个是销售，并且销售也在发送岗位清单中
                if(agent!=null && Arrays.asList(positionArray).contains(String.valueOf(ConstantCfg.POSITION_SALES_11))){
                    receiverMap.put(agent.getDdUserName(),agent.getName());
                    continue;
                }
                //如果是内勤，并且内勤岗位在岗位清单中
                Employee employee = employeeService.getEmployeeByUserId(userId.longValue());
                if(employee!=null && Arrays.asList(positionArray).contains(String.valueOf(employee.getPosition()))){
                    User user = userService.getUserById(employee.getUserId());
                    if(user!=null){
                        receiverMap.put(user.getDDUserName(),employee.getName());
                    }
                }
            }
        }

        return receiverMap;
    }

    public static void main(String[] args){
        String a = "\\{receiverName}：您好！\\{orderId}号订单的解押材料预计再有三天可以领取，请关注，谢谢！";
        System.out.println(a.replaceAll("receiverName","刘小松"));
    }
}
