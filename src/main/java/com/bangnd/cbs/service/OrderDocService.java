package com.bangnd.cbs.service;

import com.bangnd.cbs.entity.OrderDocument;

import java.util.List;

public interface OrderDocService {
    public void save(OrderDocument orderDocument);

    public List<OrderDocument> findAllByOrderId(Long orderId);

    public List<OrderDocument> findAllByOrderIdAndType(Long orderId,int type);
}
