package com.bangnd.cbs.service;

import com.bangnd.cbs.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomerList();

    public Customer findCustomerById(long id);

    public void save(Customer customer);

    public void edit(Customer customer);

    public void delete(Long id);
}
