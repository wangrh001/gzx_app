package com.bangnd.finance.service.impl;

import com.bangnd.finance.entity.PaymentPayDataType;
import com.bangnd.finance.repository.PaymentPayDataTypeRepository;
import com.bangnd.finance.service.PaymentPayDataTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentPayDataTypeServiceImpl implements PaymentPayDataTypeService {
    @Autowired
    private PaymentPayDataTypeRepository paymentPayDataTypeRepository;

    @Override
    public List<PaymentPayDataType> getAll() {
        return paymentPayDataTypeRepository.findAll();
    }

    @Override
    public PaymentPayDataType getPaymentPayDataTypeById(int id) {
        return paymentPayDataTypeRepository.findOne(id);
    }
}