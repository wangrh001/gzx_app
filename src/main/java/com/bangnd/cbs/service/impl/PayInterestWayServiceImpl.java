package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.PayInterestWay;
import com.bangnd.cbs.repository.PayInterestWayRepository;
import com.bangnd.cbs.service.PayInterestWayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayInterestWayServiceImpl implements PayInterestWayService {
    @Autowired
    PayInterestWayRepository payInterestWayRepository;

    @Override
    public List<PayInterestWay> getAll() {
        return payInterestWayRepository.findAll();
    }

    @Override
    public PayInterestWay getPayInterestWayById(int id) {
        return payInterestWayRepository.getOne(id);
    }
}
