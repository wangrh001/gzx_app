package com.bangnd.finance.service.impl;

import com.bangnd.finance.entity.AccountAccountState;
import com.bangnd.finance.repository.AccountAccountStateRepository;
import com.bangnd.finance.service.AccountAccountStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountAccountStateServiceImpl implements AccountAccountStateService {
    @Autowired
    private AccountAccountStateRepository accountAccountStateRepository;

    @Override
    public List<AccountAccountState> getAll() {
        return accountAccountStateRepository.findAll();
    }

    @Override
    public AccountAccountState getAccountAccountStateById(int id) {
        return accountAccountStateRepository.findOne(id);
    }
}