package com.bangnd.sales.vo;

import javax.persistence.*;
import java.util.*;
import java.math.BigDecimal;

public class CommissionVO {
    @Column
    public long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public String businessTypeName;
    @Column
    public String productTypeName;
    @Column
    public int productId;

    public String getBusinessTypeName() {
        return businessTypeName;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public int getProductId() {
        return productId;
    }

    public void setBusinessTypeName(String businessTypeName) {
        this.businessTypeName = businessTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}