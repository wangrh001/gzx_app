package com.bangnd.cbs.repository;

import com.bangnd.cbs.entity.CustomerCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerCreditRepository extends JpaRepository<CustomerCredit, Long> {
    public CustomerCredit findById(@Param(value="id") long id);
}
