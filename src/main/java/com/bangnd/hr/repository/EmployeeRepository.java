package com.bangnd.hr.repository;

import com.bangnd.hr.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor {
    public Employee findById(@Param(value = "id") long id);

    public List<Employee> findByStateNot(@Param(value = "status") int status);

    @Query("select e from Employee e where e.state<>100")
    public List<Employee> findAll();

    @Query("select e from Employee e where e.userId=:userId")
    public Employee findOneByUserId(@Param(value="userId") long userId);
}