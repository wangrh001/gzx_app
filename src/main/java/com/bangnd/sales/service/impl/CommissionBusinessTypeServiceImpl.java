package com.bangnd.sales.service.impl;

import com.bangnd.sales.entity.*;
import com.bangnd.sales.service.*;
import com.bangnd.sales.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommissionBusinessTypeServiceImpl implements CommissionBusinessTypeService {
    @Autowired
    private CommissionBusinessTypeRepository commissionBusinessTypeRepository;

    @Override
    public List<CommissionBusinessType> getAll() {
        return commissionBusinessTypeRepository.findAll();
    }

    @Override
    public CommissionBusinessType getCommissionBusinessTypeById(int id) {
        return commissionBusinessTypeRepository.findOne(id);
    }
}