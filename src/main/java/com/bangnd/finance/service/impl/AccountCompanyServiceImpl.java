package com.bangnd.finance.service.impl;

import com.bangnd.finance.entity.AccountCompany;
import com.bangnd.finance.repository.AccountCompanyRepository;
import com.bangnd.finance.service.AccountCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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