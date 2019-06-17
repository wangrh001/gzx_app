package com.bangnd.cbs.service.impl;

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
    public void remindNextOperator(long userId,int buttonId,OrderPool orderPool,String actionName) throws Exception {
        //发送钉钉信息给待处理人
        User user = userService.getUserById(orderPool.getUserId());
        User operator = userService.getUserById(userId);
        if (user != null && user.getDDUserName() != null && !"".equals(user.getDDUserName())) {
            Employee operatorEmployee = employeeService.getEmployeeByUserId(operator.getId());
            Resource resource = resourceService.getResourceById(buttonId);
            String ctx="";
            Employee employee = employeeService.getEmployeeByUserId(orderPool.getUserId());
            if(employee!=null) {
                ctx = employee.getName() + "：您好！" + operatorEmployee.getName() + "已经" + resource.getName() + "，请您对" + orderPool.getOrderId() + "号订单尽快进行"+actionName+"，谢谢！";
            }else {
                Agent agent = agentService.getAgentByUserId(orderPool.getUserId());
                ctx = agent.getName() + "：您好！" + operatorEmployee.getName() + "已经" + resource.getName() + "，请您对" + orderPool.getOrderId() + "号订单尽快进行"+actionName+"，谢谢！";
            }
            dingDingGWService.sendMessage(user.getDDUserName(), ctx);
        }
    }
}
