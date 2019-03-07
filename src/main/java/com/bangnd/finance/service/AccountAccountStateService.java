package com.bangnd.finance.service;

import com.bangnd.finance.entity.*;

import java.util.List;

public interface AccountAccountStateService {
    public List<AccountAccountState> getAll();

    public AccountAccountState getAccountAccountStateById(int id);
}