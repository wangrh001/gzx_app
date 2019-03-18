package com.bangnd.crm.service.impl;

import com.bangnd.crm.entity.CustSex;
import com.bangnd.crm.repository.CustSexRepository;
import com.bangnd.crm.service.CustSexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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