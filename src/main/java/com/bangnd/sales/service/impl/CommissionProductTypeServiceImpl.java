package com.bangnd.sales.service.impl;

import com.bangnd.sales.entity.CommissionProductType;
import com.bangnd.sales.repository.CommissionProductTypeRepository;
import com.bangnd.sales.service.CommissionProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommissionProductTypeServiceImpl implements CommissionProductTypeService {
    @Autowired
    private CommissionProductTypeRepository commissionProductTypeRepository;

    @Override
    public List<CommissionProductType> getAll() {
        return commissionProductTypeRepository.findAll();
    }

    @Override
    public CommissionProductType getCommissionProductTypeById(int id) {
        return commissionProductTypeRepository.findOne(id);
    }
}