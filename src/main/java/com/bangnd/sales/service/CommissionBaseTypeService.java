package com.bangnd.sales.service;

import com.bangnd.sales.entity.*;

import java.util.List;

public interface CommissionBaseTypeService {
    public List<CommissionBaseType> getAll();

    public CommissionBaseType getCommissionBaseTypeById(int id);
}