package com.bangnd.sales.service.impl;

import com.bangnd.sales.entity.CommissionLevel;
import com.bangnd.sales.repository.CommissionLevelRepository;
import com.bangnd.sales.service.CommissionLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommissionLevelServiceImpl implements CommissionLevelService {
    @Autowired
    private CommissionLevelRepository commissionLevelRepository;

    @Override
    public List<CommissionLevel> getAll() {
        return commissionLevelRepository.findAll();
    }

    @Override
    public CommissionLevel getCommissionLevelById(int id) {
        return commissionLevelRepository.findOne(id);
    }
}