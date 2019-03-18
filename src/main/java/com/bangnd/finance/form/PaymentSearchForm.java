package com.bangnd.finance.form;

import javax.persistence.Column;
import java.util.Date;

public class PaymentSearchForm {
    @Column
    public String offset;
    @Column
    public String payType;
    @Column
    public Date payDateEnd;
    @Column
    public Date payDateStart;
    @Column
    public String accountName;
    @Column
    public String payState;
    @Column
    public String inOut;
    @Column
    public String ifReal;

    public String getIfReal() {
        return ifReal;
    }

    public void setIfReal(String ifReal) {
        this.ifReal = ifReal;
    }

    public String getInOut() {
        return inOut;
    }

    public void setInOut(String inOut) {
        this.inOut = inOut;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getPayType() {
        return payType;
    }

    public Date getPayDateEnd() {
        return payDateEnd;
    }

    public Date getPayDateStart() {
        return payDateStart;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getPayState() {
        return payState;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public void setPayDateEnd(Date payDateEnd) {
        this.payDateEnd = payDateEnd;
    }

    public void setPayDateStart(Date payDateStart) {
        this.payDateStart = payDateStart;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setPayState(String payState) {
        this.payState = payState;
    }
}