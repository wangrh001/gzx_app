package com.bangnd.cbs.service;

import com.bangnd.cbs.entity.Order;
import com.bangnd.cbs.form.OrderSearchForm;

import java.util.List;

public interface OrderService {
    public void save(Order order);

    public List<Order> getOrderList(OrderSearchForm orderSearchForm);

    public Order findOrderById(long ind);

    public void delete(Long id);

    public void flush(Order order);
}
