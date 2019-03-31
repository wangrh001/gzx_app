package com.bangnd.sales.vo;

import javax.persistence.Column;

public class AgentVO {
    @Column
    public long id;
    @Column
    public String name;
    @Column
    public String businessTypeName;
    @Column
    public String phoneNO;
    @Column
    public String companyName;

    @Column
    public String groupName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getBusinessTypeName() {
        return businessTypeName;
    }

    public String getPhoneNO() {
        return phoneNO;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBusinessTypeName(String businessTypeName) {
        this.businessTypeName = businessTypeName;
    }

    public void setPhoneNO(String phoneNO) {
        this.phoneNO = phoneNO;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}