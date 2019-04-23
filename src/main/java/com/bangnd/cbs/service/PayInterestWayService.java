package com.bangnd.cbs.service;

import com.bangnd.cbs.entity.PayInterestWay;

import java.util.List;

public interface PayInterestWayService {
    public List<PayInterestWay> getAll();

    public PayInterestWay getPayInterestWayById(int id);
}
