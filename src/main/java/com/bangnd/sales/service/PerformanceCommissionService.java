package com.bangnd.sales.service;

import com.bangnd.sales.entity.PerformanceCommission;
import com.bangnd.sales.form.PerformanceCommissionSearchForm;
import org.springframework.data.domain.Page;

public interface PerformanceCommissionService {
    public Page<PerformanceCommission> getPerformanceCommissionList(Integer pageNum, int size, PerformanceCommissionSearchForm performanceCommissionSearchForm);

    public void save(PerformanceCommission performanceCommission);

    public PerformanceCommission getPerformanceCommissionById(long id);

    public void merge(PerformanceCommission performanceCommission);
}