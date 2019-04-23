package com.bangnd.cbs.service;

import com.bangnd.cbs.entity.OrderProduct;

import java.util.List;

public interface OrderProductService {
    public List<OrderProduct> getOrderProductList(long id);

    public void updateOrderProductStateByOrderId(long orderId, int orderProductState, int updatorId);

    public void save(OrderProduct orderProduct);

    public void updateOrderProductState(long id, int orderProductState);

    public void syncOrderProdState(long id);

    public void delete(long id);

    public OrderProduct findById(long id);
}
