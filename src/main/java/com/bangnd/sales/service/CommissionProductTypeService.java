package com.bangnd.sales.service;

import com.bangnd.sales.entity.CommissionProductType;

import java.util.List;

public interface CommissionProductTypeService {
    public List<CommissionProductType> getAll();

    public CommissionProductType getCommissionProductTypeById(int id);
}