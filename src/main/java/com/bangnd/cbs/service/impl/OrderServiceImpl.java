package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.Order;
import com.bangnd.cbs.repository.OrderRepository;
import com.bangnd.cbs.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Override
    public void save(Order order){
        orderRepository.save(order);
    }

    @Override
    public List<Order> getOrderList() {
//        return orderRepository.findAll();
        return orderRepository.findByOrderStateNot(6);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        orderRepository.deleteByIds(id);
    }
}
