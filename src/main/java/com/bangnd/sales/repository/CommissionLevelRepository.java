package com.bangnd.sales.repository;

import com.bangnd.sales.entity.CommissionLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommissionLevelRepository extends JpaRepository<CommissionLevel, Integer> {
}