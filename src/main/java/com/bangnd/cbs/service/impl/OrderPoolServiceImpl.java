package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.OrderPool;
import com.bangnd.cbs.service.OrderPoolRepository;
import com.bangnd.cbs.service.OrderPoolService;
import com.bangnd.hr.entity.Employee;
import com.bangnd.hr.service.EmployeeService;
import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.util.entity.WorkFlow;
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

    /**
     * 注意！！这里只支持一个状态有一个岗位的人来进行处理，不支持一个状态多个人处理
     * @param orderId 订单ID
     * @param fromState 从哪个状态来
     * @param toState 到哪个状态去
     * @param userId 当前操作用户
     * @throws Exception
     *
     */
    @Override
    public void intoPool(long orderId,int fromState,int toState,long userId,int busiType) throws Exception{
        int fromPositionId = workFlowService.getPositionIdByBeforState(fromState,busiType);
        long giveUserId = 0 ;
        int intoPoolNo=0;
        //如果订单最后一个状态，就不再找下一个工作岗位了，只离开当前工作池就可以了
        if(toState==ConstantCfg.ORDER_STATE_127){
            leavePool(orderId,fromPositionId,userId);
        }else{
            int toPositionId = workFlowService.getPositionIdByBeforState(toState,busiType);
            OrderPool orderPool = new OrderPool();
            //只有一种可能，原来暂存，补充完资料，又点击了暂存，这种情况，不对订单池有任何影响；
            if(fromState!=toState){
                //第一次入池
                if(fromState==0){
                    //如果是订单暂存，那么分配的用户，还是这个用户
                    if(toState==ConstantCfg.ORDER_STATE_101){
                        giveUserId = userId;
                        intoPoolNo=1;
                        //不是订单暂存，则是订单提交
                    }else {
                        //那么就找到订单提交后需要的岗位，在这个岗位上工作量最少的那个人
                        giveUserId=getUserIdMinTask(toPositionId);
                        intoPoolNo=1;
                    }
                    //非第一次入池
                }else {
                    //如果不是第一次入池，就去看看，要去的那个岗位上，订单之前是否去过，去过还找原来的人
                    OrderPool beforOrderPool = getFirstPoolIdByOrderIdAndPosId(orderId,toPositionId);
                    if(beforOrderPool!=null){
                        giveUserId=beforOrderPool.getUserId();
                        intoPoolNo = getHaveHandleNo(giveUserId,orderId)+1;
                        //没有去过，就找要去的那个岗位上工作量最少的人
                    }else {
                        giveUserId=getUserIdMinTask(toPositionId);
                        intoPoolNo=1;
                    }
                    leavePool(orderId,fromPositionId,userId);
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


        }
    }

    /**
     * 处理离开的那个池
     * @param orderId
     * @param fromPositionId
     * @param userId
     * @throws Exception
     */
    private void leavePool(long orderId,int fromPositionId,long userId) throws Exception{
        try {
            OrderPool orderPool = orderPoolRepository.findOrderPoolByOrderIdAndPositionIdAndDoState(
                    orderId,fromPositionId,ConstantCfg.POOL_DOSTATE_2);
            orderPool.setDoState(ConstantCfg.POOL_DOSTATE_3);
            orderPool.setLeaveTime(new Date());
            orderPool.setUpdateTime(new Date());
            orderPool.setUpdator(Long.valueOf(userId).intValue());
            orderPoolRepository.save(orderPool);
        }catch (Exception e){
            e.printStackTrace();
            throw new AppException("同一个岗位同时有多个人正在处理该订单，请联系管理员处理！");
        }
    }


    /**
     *   获取该订单第一次入这一个岗位哪个用户的池中
     */
    private OrderPool getFirstPoolIdByOrderIdAndPosId(long orderId, int toPositionId) {
        List<OrderPool> orderPools = orderPoolRepository.findAllByOrderIdAndPositionId(orderId,toPositionId);
        if(orderPools!=null){
            for(OrderPool orderPool:orderPools){
                if(orderPool!=null && orderPool.getIntoPoolNo()==1){
                    return orderPool;
                }
            }
        }
        //如果是空，说明是第一次进入这个岗位池中
        return null;
    }

    private int getHaveHandleNo(long userId,long orderId){
        return orderPoolRepository.getMaxNo(userId,orderId);
    }

    /**
     * 当前岗位的所有在职用户，返回他们的工作池中任务最少的那个用户
     *
     * @param toPositionId
     * @return
     */
    private long getUserIdMinTask(int toPositionId){
        List<Employee> employees = employeeService.getEmployeeByPositionId(toPositionId);
        long minTaskUserId=0;
        if(employees!=null){
            int taskNum=10000;
            for(Employee employee:employees){
                if(employee!=null){
                     List<OrderPool> orderPools =  orderPoolRepository.findAllByUserId(employee.getUserId(),ConstantCfg.POOL_DOSTATE_2);
                     int taskNumUser =orderPools.size();
                     if(taskNumUser<=taskNum){
                         taskNum = taskNumUser;
                         minTaskUserId =employee.getUserId();
                     }
                }
            }
        }
        return minTaskUserId;
    }

    @Override
    public List<Long> getOrderListString(long userId) {
        List<Long> orderList= new ArrayList<>();
        List<OrderPool> orderPools = orderPoolRepository.findAllByUserId(userId,ConstantCfg.POOL_DOSTATE_2,ConstantCfg.POOL_DOSTATE_1);
        if(orderPools!=null){
            for(OrderPool orderPool:orderPools){
                if(orderPool!=null){
                    orderList.add(Long.valueOf(orderPool.getOrderId()));
                }
            }
        }
        return orderList;
    }

    @Override
    public OrderPool getHandling(long orderId) {
        return orderPoolRepository.findOrderPoolByOrderIdAndDoState(orderId,ConstantCfg.POOL_DOSTATE_2);
    }
}
