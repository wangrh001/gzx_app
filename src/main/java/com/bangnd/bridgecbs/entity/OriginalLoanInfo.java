package com.bangnd.bridgecbs.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "t_bridge_original_loan_info")
public class OriginalLoanInfo {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private long orderId;

    @Column
    private long orderProductId;

    //原贷款类型
    @Column
    private int type;
    @Column
    private String typeName;

    //原贷款方
    @Column
    private int organType;

    //原贷款方
    @Column
    private String organTypeName;

    //原贷款方 机构代码
    @Column
    private int organCode;

    //原贷款方 机构代码
    @Column
    private String organCodeName;

    //原贷款金额(元)
    @Column
    private BigDecimal amount;

    //原贷款本息余额(元)
    @Column
    private BigDecimal capitalInterest;

    //原贷款结束时间
    @Column
    private Date endDate;

    //原贷款还款账号
    @Column
    private String accountNO;

    //有无预存
    @Column
    private int hasPreStorage;

    @Column
    private int prostorageDays;

    //原贷款开户行
    @Column
    private int bankCode;

    //原贷款户名
    @Column
    private String accountName;

    //原贷款联系人
    @Column
    private String contactName;

    //原贷款联系电话
    @Column
    private String contactPhone;

    //赎楼方式
    @Column
    private int foreclosureType;

    //赎楼方式
    @Column
    private String foreclosureTypeName;

    //关联物业？

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getOrganType() {
        return organType;
    }

    public void setOrganType(int organType) {
        this.organType = organType;
    }

    public int getOrganCode() {
        return organCode;
    }

    public void setOrganCode(int organCode) {
        this.organCode = organCode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getCapitalInterest() {
        return capitalInterest;
    }

    public void setCapitalInterest(BigDecimal capitalInterest) {
        this.capitalInterest = capitalInterest;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAccountNO() {
        return accountNO;
    }

    public void setAccountNO(String accountNO) {
        this.accountNO = accountNO;
    }

    public int getHasPreStorage() {
        return hasPreStorage;
    }

    public void setHasPreStorage(int hasPreStorage) {
        this.hasPreStorage = hasPreStorage;
    }

    public int getBankCode() {
        return bankCode;
    }

    public void setBankCode(int bankCode) {
        this.bankCode = bankCode;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public int getForeclosureType() {
        return foreclosureType;
    }

    public void setForeclosureType(int foreclosureType) {
        this.foreclosureType = foreclosureType;
    }

    public int getProstorageDays() {
        return prostorageDays;
    }

    public void setProstorageDays(int prostorageDays) {
        this.prostorageDays = prostorageDays;
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

    public String getOrganTypeName() {
        return organTypeName;
    }

    public void setOrganTypeName(String organTypeName) {
        this.organTypeName = organTypeName;
    }

    public String getForeclosureTypeName() {
        return foreclosureTypeName;
    }

    public void setForeclosureTypeName(String foreclosureTypeName) {
        this.foreclosureTypeName = foreclosureTypeName;
    }

    public String getOrganCodeName() {
        return organCodeName;
    }

    public void setOrganCodeName(String organCodeName) {
        this.organCodeName = organCodeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
