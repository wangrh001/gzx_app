package com.bangnd.hr.service.impl;

import com.bangnd.hr.entity.*;
import com.bangnd.hr.service.*;
import com.bangnd.hr.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeTechGradeServiceImpl implements EmployeeTechGradeService {
    @Autowired
    private EmployeeTechGradeRepository employeeTechGradeRepository;

    @Override
    public List<EmployeeTechGrade> getAll() {
        return employeeTechGradeRepository.findAll();
    }

    @Override
    public EmployeeTechGrade getEmployeeTechGradeById(int id) {
        return employeeTechGradeRepository.findOne(id);
    }
}