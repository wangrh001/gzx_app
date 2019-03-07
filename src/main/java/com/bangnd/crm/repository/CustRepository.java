package com.bangnd.crm.repository;

import com.bangnd.crm.entity.Cust;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CustRepository extends JpaRepository<Cust, Long>, JpaSpecificationExecutor {
    public Cust findById(@Param(value = "id") long id);

    List<Cust> findByStateNot(@Param(value = "status") int status);
}