package com.bangnd.finance.service;

import com.bangnd.finance.entity.*;

import java.util.List;

public interface AccountingRuleFeeTypeService {
    public List<AccountingRuleFeeType> getAll();

    public AccountingRuleFeeType getAccountingRuleFeeTypeById(int id);
}