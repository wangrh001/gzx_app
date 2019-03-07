package com.bangnd.crm.service;

import com.bangnd.crm.entity.*;

import java.util.List;

public interface CustJobService {
    public List<CustJob> getAll();

    public CustJob getCustJobById(int id);
}