package com.bangnd.hr.service;

import com.bangnd.hr.entity.*;

import java.util.List;

public interface EmployeeCityService {
    public List<EmployeeCity> getAll();

    public EmployeeCity getEmployeeCityById(int id);
}