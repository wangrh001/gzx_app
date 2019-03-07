package com.bangnd.crm.service.impl;

import com.bangnd.crm.entity.*;
import com.bangnd.crm.service.*;
import com.bangnd.crm.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustSexServiceImpl implements CustSexService {
    @Autowired
    private CustSexRepository custSexRepository;

    @Override
    public List<CustSex> getAll() {
        return custSexRepository.findAll();
    }

    @Override
    public CustSex getCustSexById(int id) {
        return custSexRepository.findOne(id);
    }
}