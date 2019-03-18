package com.bangnd.hr.service;

import com.bangnd.hr.entity.Salary;
import com.bangnd.hr.form.SalarySearchForm;
import org.springframework.data.domain.Page;

public interface SalaryService {
    public Page<Salary> getSalaryList(Integer pageNum, int size, SalarySearchForm salarySearchForm);

    public void save(Salary salary);

    public Salary getSalaryById(long id);

    public void merge(Salary salary);
}