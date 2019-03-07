package com.bangnd.finance.service;

import com.bangnd.finance.entity.Account;
import com.bangnd.finance.form.AccountSearchForm;

import java.util.List;

public interface AccountService {
    public List<Account> getAccountList(AccountSearchForm accountSearchForm);

    public void save(Account account);

    public Account getAccountById(long id);

    public void merge(Account account);
}