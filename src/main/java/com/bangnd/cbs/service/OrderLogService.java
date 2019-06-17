package com.bangnd.cbs.service;

import com.bangnd.cbs.entity.OrderLog;
import com.bangnd.util.entity.FormatInfoObject;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderLogService {
    public void save(OrderLog orderLog);

    public Page<OrderLog> getAllLogByOrderId(Integer pageNum, int size, long orderId);

    public boolean isHandleOrder(long orderId, long userId);
    public void recordLog(long orderId, long userId, int buttonId,int actionId,String desc);
    public void recordLog(long orderId, long userId, int buttonId,int actionId,FormatInfoObject formatInfoObject,String desc);
    public List<Long> getAllLogByOrderId(long orderId);
}
