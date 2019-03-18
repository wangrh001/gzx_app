package com.bangnd.sales.service.impl;

import com.bangnd.sales.entity.TelSalesTaskDelay;
import com.bangnd.sales.repository.TelSalesTaskDelayRepository;
import com.bangnd.sales.service.TelSalesTaskDelayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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