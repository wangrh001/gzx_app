package com.bangnd.hr.service;

import com.bangnd.hr.entity.Employee;
import com.bangnd.hr.form.EmployeeSearchForm;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getEmployeeList(EmployeeSearchForm employeeSearchForm);

    public void save(Employee employee);

    public Employee getEmployeeById(long id);

    public void merge(Employee employee);
}