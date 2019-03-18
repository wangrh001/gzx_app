package com.bangnd.sales.service;

import com.bangnd.sales.entity.CommissionChannelType;

import java.util.List;

public interface CommissionChannelTypeService {
    public List<CommissionChannelType> getAll();

    public CommissionChannelType getCommissionChannelTypeById(int id);
}