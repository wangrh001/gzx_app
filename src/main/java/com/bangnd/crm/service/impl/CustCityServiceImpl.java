package com.bangnd.crm.service.impl;

import com.bangnd.crm.entity.CustCity;
import com.bangnd.crm.repository.CustCityRepository;
import com.bangnd.crm.service.CustCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustCityServiceImpl implements CustCityService {
    @Autowired
    private CustCityRepository custCityRepository;

    @Override
    public List<CustCity> getAll() {
        return custCityRepository.findAll();
    }

    @Override
    public CustCity getCustCityById(int id) {
        return custCityRepository.findOne(id);
    }
}