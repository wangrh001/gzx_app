package com.bangnd.hr.service;

import com.bangnd.hr.entity.Employee;
import com.bangnd.hr.form.EmployeeSearchForm;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    public Page<Employee> getEmployeeList(Integer pageNum, int size, EmployeeSearchForm employeeSearchForm);

    public void save(Employee employee);

    public Employee getEmployeeById(long id);

    public void merge(Employee employee);

    public List<Employee> getAll();

    public void bandUser(long employeeId, long userId,String userName);

    public Employee getEmployeeByUserId(long userId);

    public List<Employee> getEmployeeByEmployeeName(String employeeName);

    public List<Employee> getEmployeeByPositionId(int positionId);
}