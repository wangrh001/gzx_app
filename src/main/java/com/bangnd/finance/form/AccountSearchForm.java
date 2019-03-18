package com.bangnd.finance.form;

import javax.persistence.Column;

public class AccountSearchForm {
    @Column
    public String accountNames;
    @Column
    public String bank;

    public String getAccountNames() {
        return accountNames;
    }

    public String getBank() {
        return bank;
    }

    public void setAccountNames(String accountNames) {
        this.accountNames = accountNames;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
}