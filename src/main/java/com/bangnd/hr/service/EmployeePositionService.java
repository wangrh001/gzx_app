package com.bangnd.hr.service;

import com.bangnd.hr.entity.*;

import java.util.List;

public interface EmployeePositionService {
    public List<EmployeePosition> getAll();

    public EmployeePosition getEmployeePositionById(int id);
}