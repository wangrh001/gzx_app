package com.bangnd.finance.service.impl;

import com.bangnd.finance.entity.PaymentInOut;
import com.bangnd.finance.repository.PaymentInOutRepository;
import com.bangnd.finance.service.PaymentInOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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