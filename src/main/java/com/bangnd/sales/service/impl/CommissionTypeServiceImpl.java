package com.bangnd.sales.service.impl;

import com.bangnd.sales.entity.*;
import com.bangnd.sales.service.*;
import com.bangnd.sales.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommissionTypeServiceImpl implements CommissionTypeService {
    @Autowired
    private CommissionTypeRepository commissionTypeRepository;

    @Override
    public List<CommissionType> getAll() {
        return commissionTypeRepository.findAll();
    }

    @Override
    public CommissionType getCommissionTypeById(int id) {
        return commissionTypeRepository.findOne(id);
    }
}