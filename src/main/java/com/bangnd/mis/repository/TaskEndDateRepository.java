package com.bangnd.mis.repository;

import com.bangnd.mis.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskEndDateRepository extends JpaRepository<TaskEndDate, Integer> {
}