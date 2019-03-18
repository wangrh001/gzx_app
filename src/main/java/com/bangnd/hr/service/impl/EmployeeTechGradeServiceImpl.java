package com.bangnd.hr.service.impl;

import com.bangnd.hr.entity.EmployeeTechGrade;
import com.bangnd.hr.repository.EmployeeTechGradeRepository;
import com.bangnd.hr.service.EmployeeTechGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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