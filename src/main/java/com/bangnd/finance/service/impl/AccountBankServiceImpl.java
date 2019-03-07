package com.bangnd.finance.service.impl;

import com.bangnd.finance.entity.*;
import com.bangnd.finance.service.*;
import com.bangnd.finance.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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