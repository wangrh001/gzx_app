package com.bangnd.finance.service.impl;

import com.bangnd.finance.entity.PaymentPayState;
import com.bangnd.finance.repository.PaymentPayStateRepository;
import com.bangnd.finance.service.PaymentPayStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentPayStateServiceImpl implements PaymentPayStateService {
    @Autowired
    private PaymentPayStateRepository paymentPayStateRepository;

    @Override
    public List<PaymentPayState> getAll() {
        return paymentPayStateRepository.findAll();
    }

    @Override
    public PaymentPayState getPaymentPayStateById(int id) {
        return paymentPayStateRepository.findOne(id);
    }
}