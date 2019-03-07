package com.bangnd.cbs.form;

import javax.persistence.*;
import java.util.*;

public class ProductSearchForm {
    @Column
    public String productName;
    @Column
    public String bankId;
    @Column
    public String productType;

    @Column
    public String busiType;

    public String getBusiType() {
        return busiType;
    }

    public void setBusiType(String busiType) {
        this.busiType = busiType;
    }

    public String getProductName() {
        return productName;
    }

    public String getBankId() {
        return bankId;
    }

    public String getProductType() {
        return productType;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

}