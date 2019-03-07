package com.bangnd.hr.repository;

import com.bangnd.hr.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface SalaryRepository extends JpaRepository<Salary, Long>, JpaSpecificationExecutor {
    public Salary findById(@Param(value = "id") long id);

    List<Salary> findByStateNot(@Param(value = "status") int status);
}