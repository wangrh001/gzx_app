package com.bangnd.hr.repository;

import com.bangnd.hr.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDeptRepository extends JpaRepository<EmployeeDept, Integer> {
}