package com.bangnd.sales.service;

import com.bangnd.sales.entity.*;

import java.util.List;

public interface PerformanceCommissionProcessService {
    public List<PerformanceCommissionProcess> getAll();

    public PerformanceCommissionProcess getPerformanceCommissionProcessById(int id);
}