package com.bangnd.sales.service;

import com.bangnd.sales.entity.*;

import java.util.List;

public interface TelSalesTaskDelayService {
    public List<TelSalesTaskDelay> getAll();

    public TelSalesTaskDelay getTelSalesTaskDelayById(int id);
}