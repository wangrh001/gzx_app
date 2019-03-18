package com.bangnd.finance.vo;

import javax.persistence.Column;

public class AccountingRuleVO {
    @Column
    public long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public String feeTypeName;
    @Column
    public String debitSideName;
    @Column
    public String creditSideName;

    public String getFeeTypeName() {
        return feeTypeName;
    }

    public String getDebitSideName() {
        return debitSideName;
    }

    public String getCreditSideName() {
        return creditSideName;
    }

    public void setFeeTypeName(String feeTypeName) {
        this.feeTypeName = feeTypeName;
    }

    public void setDebitSideName(String debitSideName) {
        this.debitSideName = debitSideName;
    }

    public void setCreditSideName(String creditSideName) {
        this.creditSideName = creditSideName;
    }
}