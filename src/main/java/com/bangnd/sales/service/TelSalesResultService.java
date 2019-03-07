package com.bangnd.sales.service;

import com.bangnd.sales.entity.*;

import java.util.List;

public interface TelSalesResultService {
    public List<TelSalesResult> getAll();

    public TelSalesResult getTelSalesResultById(int id);
}