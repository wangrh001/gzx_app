package com.bangnd.cbs.service;

import com.bangnd.cbs.entity.OrderProduct;

import java.util.List;

public interface OrderProductService {
    public List<OrderProduct> getOrderProductList(long id);

    public void save(OrderProduct orderProduct);

    public void delete(long id);

    public OrderProduct findById(long id);
}
