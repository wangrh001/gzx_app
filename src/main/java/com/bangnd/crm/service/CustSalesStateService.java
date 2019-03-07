package com.bangnd.crm.service;

import com.bangnd.crm.entity.*;

import java.util.List;

public interface CustSalesStateService {
    public List<CustSalesState> getAll();

    public CustSalesState getCustSalesStateById(int id);
}