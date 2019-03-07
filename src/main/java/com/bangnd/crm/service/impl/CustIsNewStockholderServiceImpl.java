package com.bangnd.crm.service.impl;

import com.bangnd.crm.entity.*;
import com.bangnd.crm.service.*;
import com.bangnd.crm.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustIsNewStockholderServiceImpl implements CustIsNewStockholderService {
    @Autowired
    private CustIsNewStockholderRepository custIsNewStockholderRepository;

    @Override
    public List<CustIsNewStockholder> getAll() {
        return custIsNewStockholderRepository.findAll();
    }

    @Override
    public CustIsNewStockholder getCustIsNewStockholderById(int id) {
        return custIsNewStockholderRepository.findOne(id);
    }
}