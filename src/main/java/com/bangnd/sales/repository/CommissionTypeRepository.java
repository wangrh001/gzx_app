package com.bangnd.sales.repository;

import com.bangnd.sales.entity.CommissionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommissionTypeRepository extends JpaRepository<CommissionType, Integer> {
}