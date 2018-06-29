package com.bangnd.cbs.service;

import com.bangnd.cbs.entity.TCustomer;

import java.util.List;

public interface CustomerService {

    public List<TCustomer> getCustomerList();

    public TCustomer findCustomerById(long id);

    public void save(TCustomer customer);

    public void edit(TCustomer customer);

    public void delete(long id);
}
