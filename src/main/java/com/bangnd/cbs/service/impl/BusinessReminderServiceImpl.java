package com.bangnd.cbs.service.impl;

import com.bangnd.batch.jobs.client.SendWorkMessageJob;
import com.bangnd.cbs.entity.OrderPool;
import com.bangnd.cbs.service.BusinessReminderService;
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
                ctx = employee.getName() + "：您好！" + operatorEmployee.getName() + "已经" + resource.getName() + ",请您对" + orderPool.getOrderId() + "号订单尽快进行"+actionName+"，谢谢！";
            }else {
                Agent agent = agentService.getAgentByUserId(orderPool.getUserId());
                ctx = agent.getName() + "：您好！" + operatorEmployee.getName() + "已经" + resource.getName() + ",请您对" + orderPool.getOrderId() + "号订单尽快进行"+actionName+"，谢谢！";
            }
            SendWorkMessageJob.sendMessage(user.getDDUserName(), ctx);
        }
    }
    //对一个关键时间节点，进行应该某一个操作的提醒：比如，提醒去拿解抵押材料；提醒回款
    //对在某一个岗位池中超过某一个时间进行提醒
}
