package com.bangnd.sales.service.impl;

import com.bangnd.sales.entity.*;
import com.bangnd.sales.service.*;
import com.bangnd.sales.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerformanceCommissionProcessServiceImpl implements PerformanceCommissionProcessService {
    @Autowired
    private PerformanceCommissionProcessRepository performanceCommissionProcessRepository;

    @Override
    public List<PerformanceCommissionProcess> getAll() {
        return performanceCommissionProcessRepository.findAll();
    }

    @Override
    public PerformanceCommissionProcess getPerformanceCommissionProcessById(int id) {
        return performanceCommissionProcessRepository.findOne(id);
    }
}