package com.bangnd.cbs.service.impl;

import com.bangnd.bridgecbs.entity.BridgeOrder;
import com.bangnd.cbs.entity.OrderPool;
import com.bangnd.cbs.service.BusinessReminderService;
import com.bangnd.gw.DingDingGWService;
import com.bangnd.hr.entity.Employee;
import com.bangnd.hr.service.EmployeeService;
import com.bangnd.sales.entity.Agent;
import com.bangnd.sales.service.AgentService;
import com.bangnd.ums.entity.Resource;
import com.bangnd.ums.entity.User;
import com.bangnd.ums.service.ResourceService;
import com.bangnd.ums.service.UserService;
import com.bangnd.util.cfg.ConstantCfg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessReminderServiceImpl implements BusinessReminderService {
    @Autowired
    UserService userService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    AgentService agentService;
    @Autowired
    ResourceService resourceService;
    @Autowired
    DingDingGWService dingDingGWService;

    @Override
    public void remindNextOperator(long userId,int buttonId,OrderPool orderPool,String actionName,String loanName) throws Exception {
        //发送钉钉信息给待处理人
        User user = userService.getUserById(orderPool.getUserId());
        User operator = userService.getUserById(userId);
        if (user != null && user.getDDUserName() != null && !"".equals(user.getDDUserName())) {
            Employee operatorEmployee = employeeService.getEmployeeByUserId(operator.getId());
            Resource resource = resourceService.getResourceById(buttonId);
            String ctx="";
            Employee employee = employeeService.getEmployeeByUserId(orderPool.getUserId());
            if(employee!=null) {
                ctx = employee.getName() + "：您好！" + operatorEmployee.getName() + "已经" + resource.getName() + "，请您对" + loanName + "的借款业务尽快进行"+actionName+"，谢谢！";
            }else {
                Agent agent = agentService.getAgentByUserId(orderPool.getUserId());
                ctx = agent.getName() + "：您好！" + operatorEmployee.getName() + "已经" + resource.getName() + "，请您对" + loanName + "的借款尽快进行"+actionName+"，谢谢！";
            }
            dingDingGWService.sendMessage(user.getDDUserName(), ctx);
        }
    }

    @Override
    public void informRelativePerson(int buttonId, BridgeOrder oldBridgeOrder) throws Exception {
        //初审不通过，需要把对外原因通知销售；
        if(buttonId==ConstantCfg.BUTTON_ID_125){
            Agent agent = agentService.getAgentById(oldBridgeOrder.getSalerId());
            String ctx = "";
            ctx=agent.getName()+"：您好！您提交的"+oldBridgeOrder.getLoanName()+"的垫资过桥业务申请，由于"+oldBridgeOrder.getFirstTrialNoCause()+"原因，没有审批通过，非常抱歉！";
            dingDingGWService.sendMessage(agent.getDdUserName(),ctx);
        }
        //下户需要通知下户人员；
        if(buttonId==ConstantCfg.BUTTON_ID_130){
            Employee employee = employeeService.getEmployeeById(oldBridgeOrder.getDownEmpId());
            String ctx = "";
            ctx=oldBridgeOrder.getDownEmpName()+"：您好！请你尽快对"+oldBridgeOrder.getLoanName()+"的业务进行下户。";
            dingDingGWService.sendMessage(employee.getDdUserName(),ctx);
        }
        //终审不通过，需要把对外原因通知销售
        if(buttonId==ConstantCfg.BUTTON_ID_133){
            Agent agent = agentService.getAgentById(oldBridgeOrder.getSalerId());
            String ctx = "";
            ctx=agent.getName()+"：您好！您提交的"+oldBridgeOrder.getLoanName()+"的垫资过桥业务申请，由于"+oldBridgeOrder.getSecondTrialNoCause()+"原因，没有审批终审，非常抱歉！";
            dingDingGWService.sendMessage(agent.getDdUserName(),ctx);
        }
        //总经理否决，需要通知销售（对外原因）、下户专员、风控总监、财务出纳（后三个为内部原因）
        if(buttonId==ConstantCfg.BUTTON_ID_141){
            Agent agent = agentService.getAgentById(oldBridgeOrder.getSalerId());
            String ctx = "";
            ctx=agent.getName()+"：您好！您提交的"+oldBridgeOrder.getLoanName()+"的垫资过桥业务申请，由于"+oldBridgeOrder.getThirdTrialNoCause()+"原因，没有通过总经理审批，非常抱歉！";
            dingDingGWService.sendMessage(agent.getDdUserName(),ctx);
        }
    }
}
