package com.bangnd.hr.service;

import com.bangnd.hr.entity.*;

import java.util.List;

public interface EmployeeManageGradeService {
    public List<EmployeeManageGrade> getAll();

    public EmployeeManageGrade getEmployeeManageGradeById(int id);
}