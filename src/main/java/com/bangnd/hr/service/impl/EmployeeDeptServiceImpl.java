package com.bangnd.hr.service.impl;

import com.bangnd.hr.entity.*;
import com.bangnd.hr.service.*;
import com.bangnd.hr.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDeptServiceImpl implements EmployeeDeptService {
    @Autowired
    private EmployeeDeptRepository employeeDeptRepository;

    @Override
    public List<EmployeeDept> getAll() {
        return employeeDeptRepository.findAll();
    }

    @Override
    public EmployeeDept getEmployeeDeptById(int id) {
        return employeeDeptRepository.findOne(id);
    }
}