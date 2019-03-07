package com.bangnd.sales.service.impl;

import com.bangnd.sales.entity.*;
import com.bangnd.sales.service.*;
import com.bangnd.sales.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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