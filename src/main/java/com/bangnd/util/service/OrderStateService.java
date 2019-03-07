package com.bangnd.util.service;

import com.bangnd.util.entity.OrderState;

import java.util.List;

public interface OrderStateService {
    public List<OrderState> getAll();

    public OrderState getOrderState(long id);
}
