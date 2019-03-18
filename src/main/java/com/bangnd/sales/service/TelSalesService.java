package com.bangnd.sales.service;

import com.bangnd.sales.entity.TelSales;
import com.bangnd.sales.form.TelSalesSearchForm;
import org.springframework.data.domain.Page;

public interface TelSalesService {
    public Page<TelSales> getTelSalesList(Integer pageNum, int size, TelSalesSearchForm telSalesSearchForm);

    public void save(TelSales telSales);

    public TelSales getTelSalesById(long id);

    public void merge(TelSales telSales);
}