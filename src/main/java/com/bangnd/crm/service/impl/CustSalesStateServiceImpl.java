package com.bangnd.crm.service.impl;

import com.bangnd.crm.entity.*;
import com.bangnd.crm.service.*;
import com.bangnd.crm.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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