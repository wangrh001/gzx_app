package com.bangnd.sales.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_sales_agent")
public class Agent {
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
    public String name;
    @Column
    public int businessType;
    @Column
    public int channelType;
    @Column
    public String employeeCode;
    @Column
    public String bankCode;
    @Column
    public Date cooperateBeginDate;
    @Column
    public Date cooperateEndDate;
    @Column
    public String centiCode;
    @Column
    public String phoneNO;
    @Column
    public String companyName;
    @Column
    public String userName;
    @Column
    public long userId;

    @Column
    public int jobYears;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public int getBusinessType() {
        return businessType;
    }

    public int getChannelType() {
        return channelType;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public String getBankCode() {
        return bankCode;
    }

    public Date getCooperateBeginDate() {
        return cooperateBeginDate;
    }

    public Date getCooperateEndDate() {
        return cooperateEndDate;
    }

    public String getCentiCode() {
        return centiCode;
    }

    public String getPhoneNO() {
        return phoneNO;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getUserName() {
        return userName;
    }

    public int getJobYears() {
        return jobYears;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBusinessType(int businessType) {
        this.businessType = businessType;
    }

    public void setChannelType(int channelType) {
        this.channelType = channelType;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public void setCooperateBeginDate(Date cooperateBeginDate) {
        this.cooperateBeginDate = cooperateBeginDate;
    }

    public void setCooperateEndDate(Date cooperateEndDate) {
        this.cooperateEndDate = cooperateEndDate;
    }

    public void setCentiCode(String centiCode) {
        this.centiCode = centiCode;
    }

    public void setPhoneNO(String phoneNO) {
        this.phoneNO = phoneNO;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setJobYears(int jobYears) {
        this.jobYears = jobYears;
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