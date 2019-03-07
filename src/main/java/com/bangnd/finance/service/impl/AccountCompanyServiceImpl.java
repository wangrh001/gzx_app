package com.bangnd.finance.service.impl;

import com.bangnd.finance.entity.*;
import com.bangnd.finance.service.*;
import com.bangnd.finance.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountCompanyServiceImpl implements AccountCompanyService {
    @Autowired
    private AccountCompanyRepository accountCompanyRepository;

    @Override
    public List<AccountCompany> getAll() {
        return accountCompanyRepository.findAll();
    }

    @Override
    public AccountCompany getAccountCompanyById(int id) {
        return accountCompanyRepository.findOne(id);
    }
}