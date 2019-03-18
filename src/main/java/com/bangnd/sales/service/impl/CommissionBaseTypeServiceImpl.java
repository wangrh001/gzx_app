package com.bangnd.sales.service.impl;

import com.bangnd.sales.entity.CommissionBaseType;
import com.bangnd.sales.repository.CommissionBaseTypeRepository;
import com.bangnd.sales.service.CommissionBaseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommissionBaseTypeServiceImpl implements CommissionBaseTypeService {
    @Autowired
    private CommissionBaseTypeRepository commissionBaseTypeRepository;

    @Override
    public List<CommissionBaseType> getAll() {
        return commissionBaseTypeRepository.findAll();
    }

    @Override
    public CommissionBaseType getCommissionBaseTypeById(int id) {
        return commissionBaseTypeRepository.findOne(id);
    }
}