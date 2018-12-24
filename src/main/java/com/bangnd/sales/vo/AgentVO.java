package com.bangnd.sales.vo;

import javax.persistence.*;
import java.util.*;

public class AgentVO {
    @Column
    public String name;
    @Column
    public String businessTypeName;
    @Column
    public String phoneNO;
    @Column
    public String companyName;

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
}