package com.bangnd.hr.service.impl;

import com.bangnd.hr.entity.*;
import com.bangnd.hr.service.*;
import com.bangnd.hr.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeManageGradeServiceImpl implements EmployeeManageGradeService {
    @Autowired
    private EmployeeManageGradeRepository employeeManageGradeRepository;

    @Override
    public List<EmployeeManageGrade> getAll() {
        return employeeManageGradeRepository.findAll();
    }

    @Override
    public EmployeeManageGrade getEmployeeManageGradeById(int id) {
        return employeeManageGradeRepository.findOne(id);
    }
}