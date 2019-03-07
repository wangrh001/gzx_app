package com.bangnd.sales.service;

import com.bangnd.sales.entity.TelSales;
import com.bangnd.sales.form.TelSalesSearchForm;

import java.util.List;

public interface TelSalesService {
    public List<TelSales> getTelSalesList(TelSalesSearchForm telSalesSearchForm);

    public void save(TelSales telSales);

    public TelSales getTelSalesById(long id);

    public void merge(TelSales telSales);
}