package com.bangnd.hr.service;

import com.bangnd.hr.entity.SalaryExtendState;

import java.util.List;

public interface SalaryExtendStateService {
    public List<SalaryExtendState> getAll();

    public SalaryExtendState getSalaryExtendStateById(int id);
}