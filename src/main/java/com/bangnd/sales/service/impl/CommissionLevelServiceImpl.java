package com.bangnd.sales.service.impl;

import com.bangnd.sales.entity.*;
import com.bangnd.sales.service.*;
import com.bangnd.sales.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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