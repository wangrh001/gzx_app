package com.bangnd.finance.service.impl;

import com.bangnd.finance.entity.*;
import com.bangnd.finance.service.*;
import com.bangnd.finance.repository.*;

import java.util.List;

import com.bangnd.util.cfg.ConstantCfg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentPayTypeServiceImpl implements PaymentPayTypeService {
    @Autowired
    private PaymentPayTypeRepository paymentPayTypeRepository;

    @Override
    public List<PaymentPayType> getAll() {
        return paymentPayTypeRepository.findAll();
    }

    @Override
    public PaymentPayType getPaymentPayTypeById(int id) {
        return paymentPayTypeRepository.findOne(id);
    }

    @Override
    public List<PaymentPayType> getNoBusiFee() {
        return paymentPayTypeRepository.getNoBusiType(ConstantCfg.NO_BUSI_FEE_2);
    }
}