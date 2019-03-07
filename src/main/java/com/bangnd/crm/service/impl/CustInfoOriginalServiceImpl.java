package com.bangnd.crm.service.impl;

import com.bangnd.crm.entity.*;
import com.bangnd.crm.service.*;
import com.bangnd.crm.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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