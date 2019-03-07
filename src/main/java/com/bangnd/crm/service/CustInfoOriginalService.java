package com.bangnd.crm.service;

import com.bangnd.crm.entity.*;

import java.util.List;

public interface CustInfoOriginalService {
    public List<CustInfoOriginal> getAll();

    public CustInfoOriginal getCustInfoOriginalById(int id);
}