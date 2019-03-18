package com.bangnd.sales.service;

import com.bangnd.sales.entity.CommissionWay;

import java.util.List;

public interface CommissionWayService {
    public List<CommissionWay> getAll();

    public CommissionWay getCommissionWayById(int id);
}