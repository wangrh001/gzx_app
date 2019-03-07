package com.bangnd.sales.service.impl;

import com.bangnd.sales.entity.*;
import com.bangnd.sales.service.*;
import com.bangnd.sales.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelSalesTaskDelayServiceImpl implements TelSalesTaskDelayService {
    @Autowired
    private TelSalesTaskDelayRepository telSalesTaskDelayRepository;

    @Override
    public List<TelSalesTaskDelay> getAll() {
        return telSalesTaskDelayRepository.findAll();
    }

    @Override
    public TelSalesTaskDelay getTelSalesTaskDelayById(int id) {
        return telSalesTaskDelayRepository.findOne(id);
    }
}