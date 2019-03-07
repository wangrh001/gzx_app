package com.bangnd.sales.service;

import com.bangnd.sales.entity.*;

import java.util.List;

public interface CommissionBusinessTypeService {
    public List<CommissionBusinessType> getAll();

    public CommissionBusinessType getCommissionBusinessTypeById(int id);
}