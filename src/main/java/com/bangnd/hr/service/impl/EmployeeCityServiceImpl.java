package com.bangnd.hr.service.impl;

import com.bangnd.hr.entity.EmployeeCity;
import com.bangnd.hr.repository.EmployeeCityRepository;
import com.bangnd.hr.service.EmployeeCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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