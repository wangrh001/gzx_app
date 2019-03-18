package com.bangnd.finance.service;

import com.bangnd.finance.entity.AccountBank;

import java.util.List;

public interface AccountBankService {
    public List<AccountBank> getAll();

    public AccountBank getAccountBankById(int id);
}