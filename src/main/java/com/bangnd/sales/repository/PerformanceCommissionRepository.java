package com.bangnd.sales.repository;

import com.bangnd.sales.entity.PerformanceCommission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PerformanceCommissionRepository extends JpaRepository<PerformanceCommission, Long>, JpaSpecificationExecutor {
    public PerformanceCommission findById(@Param(value = "id") long id);

    public List<PerformanceCommission> findByStateNot(@Param(value = "status") int status);

    public PerformanceCommission findByMonthAndSalerId(@Param(value = "month") String month,
                                                       @Param(value = "salerId") long salerId);

    @Query("select p from PerformanceCommission  p where p.salerId=:agentId and p.month=:month")
    public PerformanceCommission findAllByAgentIdAndMonth(@Param(value = "agentId") long agentId,
                                                                @Param(value = "month") String month);
}