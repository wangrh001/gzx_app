package com.bangnd.finance.service.impl;

import com.bangnd.finance.entity.*;
import com.bangnd.finance.service.*;
import com.bangnd.finance.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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