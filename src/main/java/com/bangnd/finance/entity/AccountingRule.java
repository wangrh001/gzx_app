package com.bangnd.finance.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "t_finance_accountingRule")
public class AccountingRule {
    @Id
    @GeneratedValue
    public long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public int feeType;
    @Column
    public int debitSide;
    @Column
    public int creditSide;

    public int getFeeType() {
        return feeType;
    }

    public int getDebitSide() {
        return debitSide;
    }

    public int getCreditSide() {
        return creditSide;
    }

    public void setFeeType(int feeType) {
        this.feeType = feeType;
    }

    public void setDebitSide(int debitSide) {
        this.debitSide = debitSide;
    }

    public void setCreditSide(int creditSide) {
        this.creditSide = creditSide;
    }

    @Column
    private int state;
    @Column
    private long creator;
    @Column
    private Date createTime;
    @Column
    private long updator;
    @Column
    private Date updateTime;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public long getCreator() {
        return creator;
    }

    public void setCreator(long creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public long getUpdator() {
        return updator;
    }

    public void setUpdator(long updator) {
        this.updator = updator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}