package com.bangnd.hr.service;

import com.bangnd.hr.entity.*;

import java.util.List;

public interface EmployeeDeptService {
    public List<EmployeeDept> getAll();

    public EmployeeDept getEmployeeDeptById(int id);
}