package com.bangnd.finance.vo;

import javax.persistence.*;
import java.util.*;
import java.math.BigDecimal;

public class AccountVO {
    @Column
    public long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public String accountNames;
    @Column
    public String amountNo;
    @Column
    public String bankName;

    public String getAccountNames() {
        return accountNames;
    }

    public String getAmountNo() {
        return amountNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setAccountNames(String accountNames) {
        this.accountNames = accountNames;
    }

    public void setAmountNo(String amountNo) {
        this.amountNo = amountNo;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}