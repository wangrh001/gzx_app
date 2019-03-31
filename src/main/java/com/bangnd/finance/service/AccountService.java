package com.bangnd.finance.service;

import com.bangnd.finance.entity.Account;
import com.bangnd.finance.form.AccountSearchForm;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AccountService {
    public Page<Account> getAccountList(Integer pageNum, int size, AccountSearchForm accountSearchForm);

    public void save(Account account);

    public Account getAccountById(long id);

    public void merge(Account account);

    public List<Account> getAll();
}