package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.Customer;
import com.bangnd.cbs.repository.CustomerRepository;
import com.bangnd.cbs.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer findCustomerById(long id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> findCustomerByOrderId(long orderId) {
        return customerRepository.findAllByorderId(orderId);
    }

    @Override
    public void save(Customer customer) {
        System.out.println("enter the serverImpl");
        customerRepository.save(customer);
    }

    @Override
    public void edit(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        Customer custome = customerRepository.findById(id);
        custome.setCustState(0);
        custome.setUpdateTime(new Date());
        customerRepository.saveAndFlush(custome);
    }
}
