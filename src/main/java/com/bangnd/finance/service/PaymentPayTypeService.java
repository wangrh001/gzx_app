package com.bangnd.finance.service;

import com.bangnd.finance.entity.PaymentPayType;

import java.util.List;

public interface PaymentPayTypeService {
    public List<PaymentPayType> getAll();

    public PaymentPayType getPaymentPayTypeById(int id);

    public List<PaymentPayType> getNoBusiFee();
}