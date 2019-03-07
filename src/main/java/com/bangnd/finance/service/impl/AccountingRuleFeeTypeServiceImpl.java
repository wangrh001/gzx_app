package com.bangnd.finance.service.impl;

import com.bangnd.finance.entity.*;
import com.bangnd.finance.service.*;
import com.bangnd.finance.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountingRuleFeeTypeServiceImpl implements AccountingRuleFeeTypeService {
    @Autowired
    private AccountingRuleFeeTypeRepository accountingRuleFeeTypeRepository;

    @Override
    public List<AccountingRuleFeeType> getAll() {
        return accountingRuleFeeTypeRepository.findAll();
    }

    @Override
    public AccountingRuleFeeType getAccountingRuleFeeTypeById(int id) {
        return accountingRuleFeeTypeRepository.findOne(id);
    }
}