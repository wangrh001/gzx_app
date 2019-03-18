package com.bangnd.sales.service.impl;

import com.bangnd.sales.entity.PerformanceCommissionProcess;
import com.bangnd.sales.repository.PerformanceCommissionProcessRepository;
import com.bangnd.sales.service.PerformanceCommissionProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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