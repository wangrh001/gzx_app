package com.bangnd.sales.service;

import com.bangnd.sales.entity.Commission;
import com.bangnd.sales.form.CommissionSearchForm;

import java.util.List;

public interface CommissionService {
    public List<Commission> getCommissionList(CommissionSearchForm commissionSearchForm);

    public void save(Commission commission);

    public Commission getCommissionById(long id);

    public void merge(Commission commission);
}