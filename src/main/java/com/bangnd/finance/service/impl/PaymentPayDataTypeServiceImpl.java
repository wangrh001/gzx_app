package com.bangnd.finance.service.impl;

import com.bangnd.finance.entity.*;
import com.bangnd.finance.service.*;
import com.bangnd.finance.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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