package com.bangnd.crm.service.impl;

import com.bangnd.crm.entity.*;
import com.bangnd.crm.service.*;
import com.bangnd.crm.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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