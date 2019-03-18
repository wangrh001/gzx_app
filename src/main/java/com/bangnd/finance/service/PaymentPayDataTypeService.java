package com.bangnd.finance.service;

import com.bangnd.finance.entity.PaymentPayDataType;

import java.util.List;

public interface PaymentPayDataTypeService {
    public List<PaymentPayDataType> getAll();

    public PaymentPayDataType getPaymentPayDataTypeById(int id);
}