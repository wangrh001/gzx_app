package com.bangnd.hr.service;

import com.bangnd.hr.entity.Salary;
import com.bangnd.hr.form.SalarySearchForm;

import java.util.List;

public interface SalaryService {
    public List<Salary> getSalaryList(SalarySearchForm salarySearchForm);

    public void save(Salary salary);

    public Salary getSalaryById(long id);

    public void merge(Salary salary);
}