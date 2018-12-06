package com.bangnd.cbs.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="t_cbs_product")
public class Product {
    @Id
    @GeneratedValue
    private long productId;

    @Column
    private String productName;

    @Column
    private long bankId;

    @Column
    private long productType;

    @Column
    private long productState;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private Date createTime;
    @Column
    private long creator;
    @Column
    private Date updateTime;
    @Column
    private long updator;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getBankId() {
        return bankId;
    }

    public void setBankId(long bankId) {
        this.bankId = bankId;
    }

    public long getProductType() {
        return productType;
    }

    public void setProductType(long productType) {
        this.productType = productType;
    }

    public long getProductState() {
        return productState;
    }

    public void setProductState(long productState) {
        this.productState = productState;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public long getCreator() {
        return creator;
    }

    public void setCreator(long creator) {
        this.creator = creator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public long getUpdator() {
        return updator;
    }

    public void setUpdator(long updator) {
        this.updator = updator;
    }
}
