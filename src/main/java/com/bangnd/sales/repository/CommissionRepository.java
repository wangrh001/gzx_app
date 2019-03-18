package com.bangnd.sales.repository;

import com.bangnd.sales.entity.Commission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommissionRepository extends JpaRepository<Commission, Long>, JpaSpecificationExecutor {
    public Commission findById(@Param(value = "id") long id);

    List<Commission> findByStateNot(@Param(value = "status") int status);
}