package com.bangnd.cbs.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "t_cbs_product")
public class Product {
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
    public String productName;
    @Column
    public int bankId;
    @Column
    public int busiType;

    @Column
    public int productType;
    @Column
    public BigDecimal brokerage;
    @Column
    public BigDecimal interest;

    @Column
    public int productState;
    @Column
    public BigDecimal lawFee;
    @Column
    public BigDecimal fairFee;
    @Column
    public BigDecimal licenseFee;
    @Column
    public Date beginDate;
    @Column
    public Date endDate;

    public String getProductName() {
        return productName;
    }

    public int getBankId() {
        return bankId;
    }

    public BigDecimal getBrokerage() {
        return brokerage;
    }

    public BigDecimal getInterest() {
        return interest;
    }


    public int getProductState() {
        return productState;
    }

    public BigDecimal getLawFee() {
        return lawFee;
    }

    public BigDecimal getFairFee() {
        return fairFee;
    }

    public BigDecimal getLicenseFee() {
        return licenseFee;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public int getBusiType() {
        return busiType;
    }

    public void setBusiType(int busiType) {
        this.busiType = busiType;
    }

    public void setBrokerage(BigDecimal brokerage) {
        this.brokerage = brokerage;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }


    public void setProductState(int productState) {
        this.productState = productState;
    }

    public void setLawFee(BigDecimal lawFee) {
        this.lawFee = lawFee;
    }

    public void setFairFee(BigDecimal fairFee) {
        this.fairFee = fairFee;
    }

    public void setLicenseFee(BigDecimal licenseFee) {
        this.licenseFee = licenseFee;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }
}