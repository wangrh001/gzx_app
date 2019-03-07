package com.bangnd.hr.service.impl;

import com.bangnd.hr.entity.*;
import com.bangnd.hr.service.*;
import com.bangnd.hr.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeCityServiceImpl implements EmployeeCityService {
    @Autowired
    private EmployeeCityRepository employeeCityRepository;

    @Override
    public List<EmployeeCity> getAll() {
        return employeeCityRepository.findAll();
    }

    @Override
    public EmployeeCity getEmployeeCityById(int id) {
        return employeeCityRepository.findOne(id);
    }
}