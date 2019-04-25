package com.bangnd.cbs.service;

import com.bangnd.cbs.entity.OrderPool;

import java.util.List;

public interface OrderPoolService {

    /**
     * 0、先判断从哪个池中出来，如果是第一次入池，不用处理；如果是从某个池中出来的，要维护原池
     * 1、判断入哪个岗位的池中；
     * 2、判断入哪个人的池中；比如A的池中
     * 3、进到A池中，维护池的状态
     *
     * @param orderId
     */
    public OrderPool intoPool(long orderId, int fromState, int toState, long userId, int busiType) throws Exception;

    public List<Long> getOrderListString(long userId);

    public OrderPool getHandling(long orderId);

}
