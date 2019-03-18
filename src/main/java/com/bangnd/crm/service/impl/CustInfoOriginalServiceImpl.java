package com.bangnd.crm.service.impl;

import com.bangnd.crm.entity.CustInfoOriginal;
import com.bangnd.crm.repository.CustInfoOriginalRepository;
import com.bangnd.crm.service.CustInfoOriginalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustInfoOriginalServiceImpl implements CustInfoOriginalService {
    @Autowired
    private CustInfoOriginalRepository custInfoOriginalRepository;

    @Override
    public List<CustInfoOriginal> getAll() {
        return custInfoOriginalRepository.findAll();
    }

    @Override
    public CustInfoOriginal getCustInfoOriginalById(int id) {
        return custInfoOriginalRepository.findOne(id);
    }
}