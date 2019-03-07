package com.bangnd.batch.repository;

import com.bangnd.batch.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTypeRepository extends JpaRepository<JobType, Integer> {
}