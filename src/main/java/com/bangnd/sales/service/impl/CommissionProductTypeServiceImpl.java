package com.bangnd.sales.service.impl;

import com.bangnd.sales.entity.*;
import com.bangnd.sales.service.*;
import com.bangnd.sales.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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