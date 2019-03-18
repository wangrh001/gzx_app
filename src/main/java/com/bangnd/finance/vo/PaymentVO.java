package com.bangnd.finance.vo;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

public class PaymentVO {
    @Column
    public long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public String inOutName;
    @Column
    public Date payDate;
    @Column
    public String accountName;
    @Column
    public BigDecimal amount;

    @Column
    public String payTypeName;

    @Column
    public int offset;

    public String getInOutName() {
        return inOutName;
    }

    public void setInOutName(String inOutName) {
        this.inOutName = inOutName;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPayTypeName() {
        return payTypeName;
    }

    public void setPayTypeName(String payTypeName) {
        this.payTypeName = payTypeName;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}