package com.bangnd.cbs.form;

import javax.persistence.*;
import java.util.*;

public class ProdInterestSearchForm {
    @Column
    public String periodType;

    @Column
    public String productId;

    public String getPeriodType() {
        return periodType;
    }

    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}