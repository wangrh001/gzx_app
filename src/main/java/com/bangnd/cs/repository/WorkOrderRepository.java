package com.bangnd.cs.repository;

import com.bangnd.cs.entity.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long>,JpaSpecificationExecutor{
public WorkOrder findById(@Param(value="id") long id);List<WorkOrder> findByStateNot(@Param(value="status") int status);}