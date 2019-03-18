package com.bangnd.finance.service;

import com.bangnd.finance.entity.AccountingRule;
import com.bangnd.finance.form.AccountingRuleSearchForm;
import org.springframework.data.domain.Page;

public interface AccountingRuleService {
    public Page<AccountingRule> getAccountingRuleList(Integer pageNum, int size, AccountingRuleSearchForm accountingRuleSearchForm);

    public void save(AccountingRule accountingRule);

    public AccountingRule getAccountingRuleById(long id);

    public void merge(AccountingRule accountingRule);
}