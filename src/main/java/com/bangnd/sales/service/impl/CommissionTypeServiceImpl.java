package com.bangnd.sales.service.impl;

import com.bangnd.sales.entity.CommissionType;
import com.bangnd.sales.repository.CommissionTypeRepository;
import com.bangnd.sales.service.CommissionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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