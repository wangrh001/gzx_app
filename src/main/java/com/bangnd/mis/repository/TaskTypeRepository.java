package com.bangnd.mis.repository;

import com.bangnd.mis.entity.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskTypeRepository extends JpaRepository<TaskType, Integer> {
}