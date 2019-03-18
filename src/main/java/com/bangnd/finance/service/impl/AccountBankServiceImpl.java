package com.bangnd.finance.service.impl;

import com.bangnd.finance.entity.AccountBank;
import com.bangnd.finance.repository.AccountBankRepository;
import com.bangnd.finance.service.AccountBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountBankServiceImpl implements AccountBankService {
    @Autowired
    private AccountBankRepository accountBankRepository;

    @Override
    public List<AccountBank> getAll() {
        return accountBankRepository.findAll();
    }

    @Override
    public AccountBank getAccountBankById(int id) {
        return accountBankRepository.findOne(id);
    }
}