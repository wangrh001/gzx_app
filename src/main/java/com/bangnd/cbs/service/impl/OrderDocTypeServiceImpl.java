package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.OrderDocType;
import com.bangnd.cbs.repository.OrderDocTypeRepository;
import com.bangnd.cbs.service.OrderDocTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDocTypeServiceImpl implements OrderDocTypeService {
    @Autowired
    public OrderDocTypeRepository orderDocTypeRepository;

    @Override
    public OrderDocType getOrderDocTypeById(int id) {
        return orderDocTypeRepository.findOne(id);
    }

    @Override
    public List<OrderDocType> getAll() {
        return orderDocTypeRepository.findAll();
    }

    @Override
    public OrderDocType getOrderDocTypeByName(String docName) {
        return orderDocTypeRepository.findOneByName(docName);
    }


}
