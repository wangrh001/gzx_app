package com.bangnd.crm.service.impl;

import com.bangnd.crm.entity.*;
import com.bangnd.crm.service.*;
import com.bangnd.crm.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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