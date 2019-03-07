package com.bangnd.finance.service;

import com.bangnd.finance.entity.*;

import java.util.List;

public interface PaymentPayStateService {
    public List<PaymentPayState> getAll();

    public PaymentPayState getPaymentPayStateById(int id);
}