package com.bangnd.hr.service;

import com.bangnd.hr.entity.EmployeeTechGrade;

import java.util.List;

public interface EmployeeTechGradeService {
    public List<EmployeeTechGrade> getAll();

    public EmployeeTechGrade getEmployeeTechGradeById(int id);
}