package com.bangnd.finance.service;

import com.bangnd.finance.entity.Account;
import com.bangnd.finance.form.AccountSearchForm;
import org.springframework.data.domain.Page;

public interface AccountService {
    public Page<Account> getAccountList(Integer pageNum, int size, AccountSearchForm accountSearchForm);

    public void save(Account account);

    public Account getAccountById(long id);

    public void merge(Account account);
}