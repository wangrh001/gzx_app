package com.bangnd.hr.service.impl;

import com.bangnd.hr.entity.*;
import com.bangnd.hr.service.*;
import com.bangnd.hr.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeePositionServiceImpl implements EmployeePositionService {
    @Autowired
    private EmployeePositionRepository employeePositionRepository;

    @Override
    public List<EmployeePosition> getAll() {
        return employeePositionRepository.findAll();
    }

    @Override
    public EmployeePosition getEmployeePositionById(int id) {
        return employeePositionRepository.findOne(id);
    }
}