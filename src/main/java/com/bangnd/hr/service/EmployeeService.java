package com.bangnd.hr.service;

import com.bangnd.hr.entity.Employee;
import java.util.List;

public interface EmployeeService {
    public List<Employee> getEmployeeList();
    public void save(Employee employee);
    public Employee findEmployeeById(long id);
    public void edit(Employee employee);
    public void delete(long id);
}
