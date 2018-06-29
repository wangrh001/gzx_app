package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.TCustomer;
import com.bangnd.cbs.repository.CustomerRepository;
import com.bangnd.cbs.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<TCustomer> getCustomerList() {
        return customerRepository.findAll();
    }

    @Override
    public TCustomer findCustomerById(long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(TCustomer customer) {
        System.out.println("enter the serverImpl");
        customerRepository.save(customer);
    }

    @Override
    public void edit(TCustomer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(long id) {
        customerRepository.delete(id);
    }
}
