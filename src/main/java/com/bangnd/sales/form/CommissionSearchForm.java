package com.bangnd.sales.form;

import javax.persistence.Column;

public class CommissionSearchForm {
    @Column
    public String businessType;
    @Column
    public String productType;
    @Column
    public String productId;
    @Column
    public String channelType;

    public String getBusinessType() {
        return businessType;
    }

    public String getProductType() {
        return productType;
    }

    public String getProductId() {
        return productId;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }
}