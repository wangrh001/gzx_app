package com.bangnd.cbs.service;

import com.bangnd.cbs.entity.OrderDocType;

import java.util.List;

public interface OrderDocTypeService {
    public OrderDocType getOrderDocTypeById(int id);
    public List<OrderDocType> getAll();
}
