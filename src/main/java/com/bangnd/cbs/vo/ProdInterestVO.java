package com.bangnd.cbs.vo;

import javax.persistence.*;
import java.util.*;
import java.math.BigDecimal;

public class ProdInterestVO {
    @Column
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
    public String periodTypeName;

    @Column
    public BigDecimal interest;

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPeriodTypeName() {
        return periodTypeName;
    }


    public void setPeriodTypeName(String periodTypeName) {
        this.periodTypeName = periodTypeName;
    }
}