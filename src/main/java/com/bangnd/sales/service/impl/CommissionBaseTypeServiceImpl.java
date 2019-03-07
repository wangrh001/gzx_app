package com.bangnd.sales.service.impl;

import com.bangnd.sales.entity.*;
import com.bangnd.sales.service.*;
import com.bangnd.sales.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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