package com.bangnd.sales.service;

import com.bangnd.sales.entity.*;

import java.util.List;

public interface CommissionLevelService {
    public List<CommissionLevel> getAll();

    public CommissionLevel getCommissionLevelById(int id);
}