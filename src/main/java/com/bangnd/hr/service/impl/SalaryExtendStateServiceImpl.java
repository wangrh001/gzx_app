package com.bangnd.hr.service.impl;

import com.bangnd.hr.entity.*;
import com.bangnd.hr.service.*;
import com.bangnd.hr.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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