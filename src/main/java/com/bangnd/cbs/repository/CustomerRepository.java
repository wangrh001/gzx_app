package com.bangnd.cbs.repository;

import com.bangnd.cbs.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Override
    List<Customer> findAll();

    public Customer findByCustomerId(@Param(value="customerId") long id);
}
