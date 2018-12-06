package com.bangnd.cbs.repository;

import com.bangnd.cbs.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Override
    List<Customer> findAll();

    public Customer findById(@Param(value="id") long id);

    @Query("select c from Customer c where orderId=:orderId and c.custState<>0")
    public List<Customer> findAllByorderId(@Param(value="orderId") long orderId);
}
