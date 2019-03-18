package com.bangnd.cbs.service;

import com.bangnd.cbs.entity.Order;
import com.bangnd.cbs.form.OrderSearchForm;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderService {
    public void save(Order order);

    public Page<Order> getOrderList(Integer pageNum, int size, List<Integer> orderStateList, OrderSearchForm orderSearchForm);

    public Order findOrderById(long ind);

    public void delete(Long id);

    public void flush(Order order);
}
