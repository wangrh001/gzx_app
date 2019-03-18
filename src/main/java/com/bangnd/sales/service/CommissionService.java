package com.bangnd.sales.service;

import com.bangnd.sales.entity.Commission;
import com.bangnd.sales.form.CommissionSearchForm;
import org.springframework.data.domain.Page;

public interface CommissionService {
    public Page<Commission> getCommissionList(Integer pageNum, int size, CommissionSearchForm commissionSearchForm);

    public void save(Commission commission);

    public Commission getCommissionById(long id);

    public void merge(Commission commission);
}