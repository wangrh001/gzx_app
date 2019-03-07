package com.bangnd.finance.service;

import com.bangnd.finance.entity.AccountingRule;
import com.bangnd.finance.form.AccountingRuleSearchForm;

import java.util.List;

public interface AccountingRuleService {
    public List<AccountingRule> getAccountingRuleList(AccountingRuleSearchForm accountingRuleSearchForm);

    public void save(AccountingRule accountingRule);

    public AccountingRule getAccountingRuleById(long id);

    public void merge(AccountingRule accountingRule);
}