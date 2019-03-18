package com.bangnd.crm.service;

import com.bangnd.crm.entity.CustCity;

import java.util.List;

public interface CustCityService {
    public List<CustCity> getAll();

    public CustCity getCustCityById(int id);
}