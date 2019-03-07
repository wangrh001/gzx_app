package com.bangnd.util.service.impl;

import com.bangnd.util.entity.PayWay;
import com.bangnd.util.repository.PayWayRepository;
import com.bangnd.util.service.PayWayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayMethodServiceImpl implements PayWayService {
    @Autowired
    PayWayRepository payWayRepository;

    @Override
    public List<PayWay> getAll() {
        return payWayRepository.findAll();
    }
}
