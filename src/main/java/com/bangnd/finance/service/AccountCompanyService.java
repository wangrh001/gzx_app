package com.bangnd.finance.service;

import com.bangnd.finance.entity.*;

import java.util.List;

public interface AccountCompanyService {
    public List<AccountCompany> getAll();

    public AccountCompany getAccountCompanyById(int id);
}