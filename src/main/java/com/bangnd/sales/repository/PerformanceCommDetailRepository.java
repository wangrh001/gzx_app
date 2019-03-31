package com.bangnd.sales.repository;

import com.bangnd.sales.entity.PerformanceCommDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PerformanceCommDetailRepository extends JpaRepository<PerformanceCommDetail, Long> {

    public PerformanceCommDetail findPerformanceCommDetailByOrderId(@Param(value = "orderId") long orderId);

    @Query("select p from PerformanceCommDetail  p where p.orderId=:orderId and p.salerId=:salerId")
    public PerformanceCommDetail findPerformanceCommDetailByOrderId(@Param(value = "orderId") long orderId,
                                                                    @Param(value = "salerId") long salerId);

    @Query("select p from PerformanceCommDetail  p where p.salerId=:salerId and p.createTime>=:startDate and p.createTime<=:endDate")
    public List<PerformanceCommDetail> findAllByAgentId(@Param(value = "salerId") long salerId,
                                                        @Param(value="xdate") Date startDate,
                                                        @Param(value = "endDate") Date endDate);

}
