package com.bangnd.sales.service;

import com.bangnd.sales.entity.PerformanceCommission;
import com.bangnd.sales.form.PerformanceCommissionSearchForm;

import java.util.List;

public interface PerformanceCommissionService {
    public List<PerformanceCommission> getPerformanceCommissionList(PerformanceCommissionSearchForm performanceCommissionSearchForm);

    public void save(PerformanceCommission performanceCommission);

    public PerformanceCommission getPerformanceCommissionById(long id);

    public void merge(PerformanceCommission performanceCommission);
}