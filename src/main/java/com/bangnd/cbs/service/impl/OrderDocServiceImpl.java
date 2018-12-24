package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.OrderDocument;
import com.bangnd.cbs.entity.OrderProduct;
import com.bangnd.cbs.repository.OrderDocRepository;
import com.bangnd.cbs.service.OrderDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDocServiceImpl implements OrderDocService {
    @Autowired
    OrderDocRepository orderDocRepository;


    @Override
    public void save(OrderDocument orderDocument) {
        orderDocRepository.save(orderDocument);
    }

    @Override
    public List<OrderDocument> findAllByOrderId(Long orderId) {
        return orderDocRepository.findAllByOrderId(orderId);
    }
}
