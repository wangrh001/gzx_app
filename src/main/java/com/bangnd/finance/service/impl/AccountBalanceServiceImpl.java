package com.bangnd.finance.service.impl;

import com.bangnd.finance.entity.AccountBalance;
import com.bangnd.finance.repository.AccountBalanceRepository;
import com.bangnd.finance.service.AccountBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountBalanceServiceImpl implements AccountBalanceService {
    @Autowired
    private AccountBalanceRepository accountBalanceRepository;

    @Override
    public List<AccountBalance> getAll() {
        return accountBalanceRepository.findAll();
    }

    @Override
    public AccountBalance getAccountBalanceById(int id) {
        return accountBalanceRepository.findOne(id);
    }
}