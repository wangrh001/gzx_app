package com.bangnd.finance.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_finance_account")
public class Account {
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
    public String accountNames;
    @Column
    public String accountNo;
    @Column
    public int bank;
    @Column
    public int accountState;
    @Column
    public int company;

    public String getAccountNames() {
        return accountNames;
    }


    public int getBank() {
        return bank;
    }

    public int getAccountState() {
        return accountState;
    }

    public int getCompany() {
        return company;
    }

    public void setAccountNames(String accountNames) {
        this.accountNames = accountNames;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }

    public void setAccountState(int accountState) {
        this.accountState = accountState;
    }

    public void setCompany(int company) {
        this.company = company;
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