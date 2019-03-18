package com.bangnd.finance.service;

import com.bangnd.finance.entity.PaymentInOut;

import java.util.List;

public interface PaymentInOutService {
    public List<PaymentInOut> getAll();

    public PaymentInOut getPaymentInOutById(int id);
}