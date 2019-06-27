package com.bangnd.cbs.service.impl;

import com.bangnd.bridgecbs.service.BridgeOrderService;
import com.bangnd.cbs.entity.OrderPool;
import com.bangnd.cbs.service.OrderPoolRepository;
import com.bangnd.cbs.service.OrderPoolService;
import com.bangnd.cbs.service.OrderService;
import com.bangnd.hr.entity.Employee;
import com.bangnd.hr.service.EmployeeService;
import com.bangnd.sales.service.AgentService;
import com.bangnd.ums.service.UserService;
import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.util.exception.AppException;
import com.bangnd.util.service.WorkFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderPoolServiceImpl implements OrderPoolService {

    @Autowired
    OrderPoolRepository orderPoolRepository;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    WorkFlowService workFlowService;
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;
    @Autowired
    AgentService agentService;
    @Autowired
    private BridgeOrderService bridgeOrderService;

    /**
     * 注意！！这里只支持一个状态有一个岗位的人来进行处理，不支持一个状态多个人处理
     *
     * @param orderId   订单ID
     * @param fromState 从哪个状态来
     * @param toState   到哪个状态去
     * @param userId    当前操作用户
     * @throws Exception
     */
    @Override
    public OrderPool intoPool(long orderId, int fromState, int toState, long userId, int busiType) throws Exception {
        int fromPositionId = 0;

        if(fromState!=0){
            fromPositionId = workFlowService.getPositionIdByBeforState(orderId,fromState, busiType);
        }
        long giveUserId = 0;
        int intoPoolNo = 0;
        //如果订单最后一个状态，就不再找下一个工作岗位了，只离开当前工作池就可以了
        if (toState == ConstantCfg.ORDER_STATE_157 || toState == ConstantCfg.ORDER_STATE_136) {
            if(fromState!=0){
                leavePool(orderId, fromPositionId, userId);
            }
        } else {
            int toPositionId = workFlowService.getPositionIdByBeforState(orderId,toState, busiType);
            OrderPool orderPool = new OrderPool();
            //只有一种可能，原来暂存，补充完资料，又点击了暂存，这种情况，不对订单池有任何影响；
            if (fromState != toState) {
                //第一次入池,应该分给运营岗
                if (fromState == 0 && toState == ConstantCfg.ORDER_STATE_131) {
                    giveUserId = getUserIdMinTask(ConstantCfg.POSITION_OPERTION_8);
                    intoPoolNo = 1;
                    //非第一次入池
                } else {
                    //如果不是第一次入池，就去看看，要去的那个岗位上，订单之前是否去过，去过还找原来的人
                    OrderPool beforOrderPool = getFirstPoolIdByOrderIdAndPosId(orderId, toPositionId);
                    if (beforOrderPool != null) {
                        giveUserId = beforOrderPool.getUserId();
                        intoPoolNo = getHaveHandleNo(giveUserId, orderId) + 1;
                        //没有去过，就找要去的那个岗位上工作量最少的人
                    } else {
                        //如果销售人员没有经过暂存就直接提交，那么池中是没有这个记录的，初审通过后，再回到销售，应该找这个订单的销售人员
                        //即：如果要去的岗位是11，那么直接找这个订单的销售.
                        if (toPositionId == 11) {
                            //根据订单id，拿到订单，在拿到这个订单的销售id，根据销售id，拿到销售，再拿到这个销售的userid
                            giveUserId = agentService.getAgentById((bridgeOrderService.getBridgeOrderById(orderId)).getSalerId()).getUserId();
                        } else {
                            giveUserId = getUserIdMinTask(toPositionId);
                        }
                        intoPoolNo = 1;
                    }
                    leavePool(orderId, fromPositionId, userId);
                }
                orderPool.setOrderId(orderId);
                orderPool.setPositionId(Long.valueOf(toPositionId).intValue());
                orderPool.setIntoTime(new Date());
                orderPool.setUserId(giveUserId);
                orderPool.setDoState(ConstantCfg.POOL_DOSTATE_2);
                orderPool.setCreateTime(new Date());
                orderPool.setCreator(Long.valueOf(userId).intValue());
                orderPool.setIntoPoolNo(intoPoolNo);
                orderPool.setState(ConstantCfg.PUBLIC_VALID_STATE);
                orderPoolRepository.save(orderPool);
            }
            return orderPool;
        }
        return null;
    }

    /**
     * 处理离开的那个池
     *
     * @param orderId
     * @param fromPositionId
     * @param userId
     * @throws Exception
     */
    private void leavePool(long orderId, int fromPositionId, long userId) throws Exception {
        try {
            OrderPool orderPool = orderPoolRepository.findOrderPoolByOrderIdAndPositionIdAndDoState(
                    orderId, fromPositionId, ConstantCfg.POOL_DOSTATE_2);
            if(orderPool!=null){
                orderPool.setDoState(ConstantCfg.POOL_DOSTATE_3);
                orderPool.setLeaveTime(new Date());
                orderPool.setUpdateTime(new Date());
                orderPool.setUpdator(Long.valueOf(userId).intValue());
                orderPoolRepository.save(orderPool);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new AppException("同一个岗位同时有多个人正在处理该订单，请联系管理员处理！");
        }
    }


    /**
     * 获取该订单第一次入这一个岗位哪个用户的池中
     */
    private OrderPool getFirstPoolIdByOrderIdAndPosId(long orderId, int toPositionId) {
        List<OrderPool> orderPools = orderPoolRepository.findAllByOrderIdAndPositionId(orderId, toPositionId);
        if (orderPools != null) {
            for (OrderPool orderPool : orderPools) {
                if (orderPool != null && orderPool.getIntoPoolNo() == 1) {
                    return orderPool;
                }
            }
        }
        //如果是空，说明是第一次进入这个岗位池中
        return null;
    }

    private int getHaveHandleNo(long userId, long orderId) {
        return orderPoolRepository.getMaxNo(userId, orderId);
    }

    /**
     * 当前岗位的所有在职用户，返回他们的工作池中任务最少的那个用户
     *
     * @param toPositionId
     * @return
     */
    private long getUserIdMinTask(int toPositionId) {
        List<Employee> employees = employeeService.getEmployeeByPositionId(toPositionId);
        long minTaskUserId = 0;
        if (employees != null) {
            int taskNum = 10000;
            for (Employee employee : employees) {
                if (employee != null) {
                    List<OrderPool> orderPools = orderPoolRepository.findAllByUserId(employee.getUserId(), ConstantCfg.POOL_DOSTATE_2);
                    int taskNumUser = orderPools.size();
                    if (taskNumUser <= taskNum) {
                        taskNum = taskNumUser;
                        minTaskUserId = employee.getUserId();
                    }
                }
            }
        }
        return minTaskUserId;
    }

    @Override
    public List<Long> getOrderListString(long userId) {
        List<Long> orderList = new ArrayList<>();
        List<OrderPool> orderPools = orderPoolRepository.findAllByUserId(userId, ConstantCfg.POOL_DOSTATE_2, ConstantCfg.POOL_DOSTATE_1);
        if (orderPools != null) {
            for (OrderPool orderPool : orderPools) {
                if (orderPool != null) {
                    orderList.add(Long.valueOf(orderPool.getOrderId()));
                }
            }
        }
        return orderList;
    }

    @Override
    public OrderPool getHandling(long orderId) {
        return orderPoolRepository.findOrderPoolByOrderIdAndDoState(orderId, ConstantCfg.POOL_DOSTATE_2);
    }

    @Override
    public void allocationHandler(long userId, long orderId) {
        orderPoolRepository.updateDoingHandler(userId,orderId);
    }
}
