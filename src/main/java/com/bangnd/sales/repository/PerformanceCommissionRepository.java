package com.bangnd.sales.repository;

import com.bangnd.sales.entity.PerformanceCommission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface PerformanceCommissionRepository extends JpaRepository<PerformanceCommission, Long>, JpaSpecificationExecutor {
    public PerformanceCommission findById(@Param(value = "id") long id);

    List<PerformanceCommission> findByStateNot(@Param(value = "status") int status);
}