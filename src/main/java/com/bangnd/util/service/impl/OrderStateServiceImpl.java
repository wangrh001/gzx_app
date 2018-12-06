package com.bangnd.util.service.impl;

import com.bangnd.util.entity.OrderState;
import com.bangnd.util.repository.OrderStateRepository;
import com.bangnd.util.service.OrderStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderStateServiceImpl implements OrderStateService {
    @Autowired
    OrderStateRepository orderStateRepository;
    @Override
    public List<OrderState> getAll() {
        return orderStateRepository.findAll();
    }

    @Override
    public OrderState getOrderState(long id) {
        return orderStateRepository.findOne(id);
    }
}
