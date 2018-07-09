package com.bangnd.cbs.service;

import com.bangnd.cbs.entity.Order;

import java.util.List;

public interface OrderService {
    public void save(Order order);
    public List<Order> getOrderList();
    public void delete(Long id);
}
