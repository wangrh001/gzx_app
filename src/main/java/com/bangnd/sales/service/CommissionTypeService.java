package com.bangnd.sales.service;

import com.bangnd.sales.entity.CommissionType;

import java.util.List;

public interface CommissionTypeService {
    public List<CommissionType> getAll();

    public CommissionType getCommissionTypeById(int id);
}