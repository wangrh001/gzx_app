package com.bangnd.crm.service;

import com.bangnd.crm.entity.CustSex;

import java.util.List;

public interface CustSexService {
    public List<CustSex> getAll();

    public CustSex getCustSexById(int id);
}