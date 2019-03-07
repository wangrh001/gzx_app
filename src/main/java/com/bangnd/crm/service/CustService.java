package com.bangnd.crm.service;

import com.bangnd.crm.entity.Cust;
import com.bangnd.crm.form.CustSearchForm;

import java.util.List;

public interface CustService {
    public List<Cust> getCustList(CustSearchForm custSearchForm);

    public void save(Cust cust);

    public Cust getCustById(long id);

    public void merge(Cust cust);
}