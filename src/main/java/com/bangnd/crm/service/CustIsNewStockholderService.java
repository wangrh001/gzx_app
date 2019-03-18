package com.bangnd.crm.service;

import com.bangnd.crm.entity.CustIsNewStockholder;

import java.util.List;

public interface CustIsNewStockholderService {
    public List<CustIsNewStockholder> getAll();

    public CustIsNewStockholder getCustIsNewStockholderById(int id);
}