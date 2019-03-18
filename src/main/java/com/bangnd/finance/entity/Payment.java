package com.bangnd.finance.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "t_finance_payment")
public class Payment {
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
    public int inOut;
    @Column
    public int ifReal;
    @Column
    public BigDecimal amount;
    @Column
    public String compCardNo;

    //对方银行ID
    @Column
    public long otherBankId;
    @Column
    public String otherCardNo;
    @Column
    public int payType;
    @Column
    public long orderId;

    @Column(nullable = true)
    public long orderProductId;

    @Column
    public Date payDate;
    @Column
    public int operatorId;
    @Column
    public String accountName;
    @Column
    public int payState;

    //1、已经核销；0、未核销
    @Column
    public int offset;

    //核销对应费用ID
    @Column
    public long relatedId;

    public int getIfReal() {
        return ifReal;
    }

    public void setIfReal(int ifReal) {
        this.ifReal = ifReal;
    }

    public int getInOut() {
        return inOut;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCompCardNo() {
        return compCardNo;
    }

    public String getOtherCardNo() {
        return otherCardNo;
    }

    public int getPayType() {
        return payType;
    }

    public long getOrderId() {
        return orderId;
    }

    public Date getPayDate() {
        return payDate;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public String getAccountName() {
        return accountName;
    }

    public int getPayState() {
        return payState;
    }

    public void setInOut(int inOut) {
        this.inOut = inOut;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setCompCardNo(String compCardNo) {
        this.compCardNo = compCardNo;
    }

    public void setOtherCardNo(String otherCardNo) {
        this.otherCardNo = otherCardNo;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setPayState(int payState) {
        this.payState = payState;
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

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public long getRelatedId() {
        return relatedId;
    }

    public void setRelatedId(long relatedId) {
        this.relatedId = relatedId;
    }

    public long getOtherBankId() {
        return otherBankId;
    }

    public void setOtherBankId(long otherBankId) {
        this.otherBankId = otherBankId;
    }

    public long getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(long orderProductId) {
        this.orderProductId = orderProductId;
    }
}