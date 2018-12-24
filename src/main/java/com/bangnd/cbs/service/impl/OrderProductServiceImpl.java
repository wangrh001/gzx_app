package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.OrderProduct;
import com.bangnd.cbs.repository.OrderProductRepository;
import com.bangnd.cbs.service.OrderProductService;
import com.bangnd.util.cfg.ConstantCfg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;

@Service
public class OrderProductServiceImpl implements OrderProductService {

    @Autowired
    OrderProductRepository orderProductRepository;

    @Override
    public List<OrderProduct> getOrderProductList(long id) {
        return orderProductRepository.findByOrderId(id,ConstantCfg.ORDER_PRODUCT_STATE_DELETE);
    }

    @Override
    public void save(OrderProduct orderProduct) {
        orderProductRepository.save(orderProduct);
    }

    @Override
    public void delete(long id) {
        OrderProduct orderProduct=orderProductRepository.findById(id);
        orderProduct.setOrderProdState(ConstantCfg.ORDER_PRODUCT_STATE_DELETE);
        orderProduct.setUpdateTime(new Date());
        orderProductRepository.save(orderProduct);
    }

    @Override
    public OrderProduct findById(long id) {
        return orderProductRepository.findById(id);
    }
}
