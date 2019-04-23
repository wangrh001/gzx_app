package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.OrderProduct;
import com.bangnd.cbs.repository.OrderProductRepository;
import com.bangnd.cbs.service.OrderProductService;
import com.bangnd.finance.entity.Payment;
import com.bangnd.finance.service.PaymentService;
import com.bangnd.util.cfg.ConstantCfg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderProductServiceImpl implements OrderProductService {

    @Autowired
    OrderProductRepository orderProductRepository;
    @Autowired
    PaymentService paymentService;

    @Override
    public List<OrderProduct> getOrderProductList(long id) {
        return orderProductRepository.findByOrderId(id, ConstantCfg.ORDER_PRODUCT_STATE_DELETE);
    }

    @Override
    public void updateOrderProductStateByOrderId(long orderId, int orderProductState, int updatorId) {
        List<OrderProduct> orderProductList = orderProductRepository.findByOrderId(orderId, ConstantCfg.ORDER_PRODUCT_STATE_DELETE);
        if (orderProductList != null) {
            for (OrderProduct orderProduct : orderProductList) {
                orderProduct.setOrderProdState(orderProductState);
                orderProduct.setUpdateTime(new Date());
                orderProduct.setUpdator(updatorId);
                orderProductRepository.save(orderProduct);
            }
        }
    }

    @Override
    public void save(OrderProduct orderProduct) {
        orderProductRepository.save(orderProduct);
    }

    @Override
    public void updateOrderProductState(long id, int orderProductState) {
        OrderProduct orderProduct = orderProductRepository.findById(id);
        orderProduct.setOrderProdState(orderProductState);
        orderProduct.setUpdateTime(new Date());
        orderProductRepository.save(orderProduct);
    }

    @Override
    public void syncOrderProdState(long id) {
        OrderProduct orderProduct = orderProductRepository.findById(id);
        List<Payment> payments = paymentService.getPaymentListByOrderProdId(id);
        for (Payment payment : payments) {
            //发现有未核销的费用，修改订单状态为费用已经生成、break;
            if (payment.getOffset() == 2) {
                orderProduct.setOrderProdState(ConstantCfg.ORDER_PRODUCT_STATE_CACLED);
                break;
            }
            //都已经核销则更新订单产品表状态为已支付
            orderProduct.setOrderProdState(ConstantCfg.ORDER_PRODUCT_STATE_FINISHED);
        }
        orderProduct.setUpdateTime(new Date());
        orderProductRepository.save(orderProduct);
    }

    @Override
    public void delete(long id) {
        OrderProduct orderProduct = orderProductRepository.findById(id);
        orderProduct.setState(ConstantCfg.ORDER_PRODUCT_STATE_DELETE);
        orderProduct.setUpdateTime(new Date());
        orderProductRepository.save(orderProduct);
    }

    @Override
    public OrderProduct findById(long id) {
        return orderProductRepository.findById(id);
    }


}
