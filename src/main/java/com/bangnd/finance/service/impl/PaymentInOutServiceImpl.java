package com.bangnd.finance.service.impl;

import com.bangnd.finance.entity.*;
import com.bangnd.finance.service.*;
import com.bangnd.finance.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentInOutServiceImpl implements PaymentInOutService {
    @Autowired
    private PaymentInOutRepository paymentInOutRepository;

    @Override
    public List<PaymentInOut> getAll() {
        return paymentInOutRepository.findAll();
    }

    @Override
    public PaymentInOut getPaymentInOutById(int id) {
        return paymentInOutRepository.findOne(id);
    }
}