package com.bangnd.sales.service.impl;

import com.bangnd.sales.entity.TelSalesResult;
import com.bangnd.sales.repository.TelSalesResultRepository;
import com.bangnd.sales.service.TelSalesResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelSalesResultServiceImpl implements TelSalesResultService {
    @Autowired
    private TelSalesResultRepository telSalesResultRepository;

    @Override
    public List<TelSalesResult> getAll() {
        return telSalesResultRepository.findAll();
    }

    @Override
    public TelSalesResult getTelSalesResultById(int id) {
        return telSalesResultRepository.findOne(id);
    }
}