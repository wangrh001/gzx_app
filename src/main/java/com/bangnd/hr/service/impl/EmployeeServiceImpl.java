package com.bangnd.hr.service.impl;

import com.bangnd.hr.entity.Employee;
import com.bangnd.hr.repository.EmployeeRepository;
import com.bangnd.hr.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployeeList() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeById(long id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public void edit(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(long id) {
        employeeRepository.delete(id);
    }
}
