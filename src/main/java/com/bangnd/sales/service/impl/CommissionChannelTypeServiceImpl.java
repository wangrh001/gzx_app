package com.bangnd.sales.service.impl;

import com.bangnd.sales.entity.*;
import com.bangnd.sales.service.*;
import com.bangnd.sales.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommissionChannelTypeServiceImpl implements CommissionChannelTypeService {
    @Autowired
    private CommissionChannelTypeRepository commissionChannelTypeRepository;

    @Override
    public List<CommissionChannelType> getAll() {
        return commissionChannelTypeRepository.findAll();
    }

    @Override
    public CommissionChannelType getCommissionChannelTypeById(int id) {
        return commissionChannelTypeRepository.findOne(id);
    }
}