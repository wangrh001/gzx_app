package com.bangnd.finance.service.impl;

import com.bangnd.finance.entity.AccountingRuleFeeType;
import com.bangnd.finance.repository.AccountingRuleFeeTypeRepository;
import com.bangnd.finance.service.AccountingRuleFeeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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