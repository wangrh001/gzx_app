package com.bangnd.bridgecbs.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="t_bridge_bank_account")
public class BankAccount {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private long orderId;

    @Column
    private long orderProductId;

    //类型
    //1、原贷款过账卡号；2、收款信息；3、新贷款过账卡号；4、回款卡号
    @Column
    private int type;

    //银行账号户名
    @Column
    private String accountName;

    //过账户证件号
    @Column
    private String accountCertiCode;

    //过账金额
    @Column
    private BigDecimal amount;

    //开户行代码
    @Column
    private int bankId;

    @Column
    private String bankIdName;

    //银行卡号
    @Column
    private String accountCode;

    @Column
    private long newLoanId;

    @Column
    private int state;

    @Column(nullable = true, unique = false)
    private Date createTime;
    @Column(nullable = true, unique = false)
    private int creator;
    @Column(nullable = true, unique = false)
    private Date updateTime;
    @Column(nullable = true, unique = false)
    private int updator;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(long orderProductId) {
        this.orderProductId = orderProductId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountCertiCode() {
        return accountCertiCode;
    }

    public void setAccountCertiCode(String accountCertiCode) {
        this.accountCertiCode = accountCertiCode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getUpdator() {
        return updator;
    }

    public void setUpdator(int updator) {
        this.updator = updator;
    }


    public long getNewLoanId() {
        return newLoanId;
    }

    public void setNewLoanId(long newLoanId) {
        this.newLoanId = newLoanId;
    }

    public String getBankIdName() {
        return bankIdName;
    }

    public void setBankIdName(String bankIdName) {
        this.bankIdName = bankIdName;
    }
}
