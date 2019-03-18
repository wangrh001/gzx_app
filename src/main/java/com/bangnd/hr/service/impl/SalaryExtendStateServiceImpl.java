package com.bangnd.hr.service.impl;

import com.bangnd.hr.entity.SalaryExtendState;
import com.bangnd.hr.repository.SalaryExtendStateRepository;
import com.bangnd.hr.service.SalaryExtendStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryExtendStateServiceImpl implements SalaryExtendStateService {
    @Autowired
    private SalaryExtendStateRepository salaryExtendStateRepository;

    @Override
    public List<SalaryExtendState> getAll() {
        return salaryExtendStateRepository.findAll();
    }

    @Override
    public SalaryExtendState getSalaryExtendStateById(int id) {
        return salaryExtendStateRepository.findOne(id);
    }
}