package com.bangnd.sales.service;

import com.bangnd.sales.entity.TelSalesResult;

import java.util.List;

public interface TelSalesResultService {
    public List<TelSalesResult> getAll();

    public TelSalesResult getTelSalesResultById(int id);
}