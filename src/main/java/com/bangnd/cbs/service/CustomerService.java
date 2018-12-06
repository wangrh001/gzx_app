package com.bangnd.cbs.service;

import com.bangnd.cbs.entity.Customer;

import java.util.List;

public interface CustomerService {

    public Customer findCustomerById(long id);

    public List<Customer> findCustomerByOrderId(long orderId);

    public void save(Customer customer);

    public void edit(Customer customer);

    public void delete(Long id);
}
