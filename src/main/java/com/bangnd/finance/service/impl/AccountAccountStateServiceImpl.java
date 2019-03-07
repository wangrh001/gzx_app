package com.bangnd.finance.service.impl;

import com.bangnd.finance.entity.*;
import com.bangnd.finance.service.*;
import com.bangnd.finance.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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