package com.bangnd.hr.service.impl;

import com.bangnd.hr.entity.EmployeeManageGrade;
import com.bangnd.hr.repository.EmployeeManageGradeRepository;
import com.bangnd.hr.service.EmployeeManageGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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