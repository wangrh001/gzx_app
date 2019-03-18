package com.bangnd.sales.service.impl;

import com.bangnd.sales.entity.CommissionChannelType;
import com.bangnd.sales.repository.CommissionChannelTypeRepository;
import com.bangnd.sales.service.CommissionChannelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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