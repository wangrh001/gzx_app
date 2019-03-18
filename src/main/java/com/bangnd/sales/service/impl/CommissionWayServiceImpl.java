package com.bangnd.sales.service.impl;

import com.bangnd.sales.entity.CommissionWay;
import com.bangnd.sales.repository.CommissionWayRepository;
import com.bangnd.sales.service.CommissionWayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommissionWayServiceImpl implements CommissionWayService {
    @Autowired
    private CommissionWayRepository commissionWayRepository;

    @Override
    public List<CommissionWay> getAll() {
        return commissionWayRepository.findAll();
    }

    @Override
    public CommissionWay getCommissionWayById(int id) {
        return commissionWayRepository.findOne(id);
    }
}