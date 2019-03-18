package com.bangnd.crm.service.impl;

import com.bangnd.crm.entity.CustSalesState;
import com.bangnd.crm.repository.CustSalesStateRepository;
import com.bangnd.crm.service.CustSalesStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustSalesStateServiceImpl implements CustSalesStateService {
    @Autowired
    private CustSalesStateRepository custSalesStateRepository;

    @Override
    public List<CustSalesState> getAll() {
        return custSalesStateRepository.findAll();
    }

    @Override
    public CustSalesState getCustSalesStateById(int id) {
        return custSalesStateRepository.findOne(id);
    }
}