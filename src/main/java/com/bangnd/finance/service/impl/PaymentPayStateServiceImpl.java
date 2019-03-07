package com.bangnd.finance.service.impl;

import com.bangnd.finance.entity.*;
import com.bangnd.finance.service.*;
import com.bangnd.finance.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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