package com.bangnd.finance.service;

import com.bangnd.finance.entity.AccountBalance;

import java.util.List;

public interface AccountBalanceService {
    public List<AccountBalance> getAll();

    public AccountBalance getAccountBalanceById(int id);
}