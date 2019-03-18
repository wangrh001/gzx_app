package com.bangnd.sales.form;

import javax.persistence.Column;

public class AgentSearchForm {
    @Column
    public String name;
    @Column
    public String businessType;
    @Column
    public String channelType;
    @Column
    public String centiCode;
    @Column
    public String phoneNO;
    @Column
    public String companyName;
    @Column
    public String userName;
    @Column
    public String jobYears;

    public String getName() {
        return name;
    }

    public String getBusinessType() {
        return businessType;
    }

    public String getChannelType() {
        return channelType;
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

    public String getJobYears() {
        return jobYears;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
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

    public void setJobYears(String jobYears) {
        this.jobYears = jobYears;
    }
}