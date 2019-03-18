package com.bangnd.crm.service.impl;

import com.bangnd.crm.entity.CustIsNewStockholder;
import com.bangnd.crm.repository.CustIsNewStockholderRepository;
import com.bangnd.crm.service.CustIsNewStockholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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