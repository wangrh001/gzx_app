package com.bangnd.cbs.repository;

import com.bangnd.cbs.entity.TCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<TCustomer, Long> {

    TCustomer findById(long id);

    Long deleteById(Long id);
}
