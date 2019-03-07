package com.bangnd.sales.service.impl;

import com.bangnd.sales.entity.*;
import com.bangnd.sales.service.*;
import com.bangnd.sales.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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