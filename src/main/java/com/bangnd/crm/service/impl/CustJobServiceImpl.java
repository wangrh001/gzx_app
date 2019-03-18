package com.bangnd.crm.service.impl;

import com.bangnd.crm.entity.CustJob;
import com.bangnd.crm.repository.CustJobRepository;
import com.bangnd.crm.service.CustJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustJobServiceImpl implements CustJobService {
    @Autowired
    private CustJobRepository custJobRepository;

    @Override
    public List<CustJob> getAll() {
        return custJobRepository.findAll();
    }

    @Override
    public CustJob getCustJobById(int id) {
        return custJobRepository.findOne(id);
    }
}