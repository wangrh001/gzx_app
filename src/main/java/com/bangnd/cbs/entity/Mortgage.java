package com.bangnd.cbs.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="t_cust_mortgage")
public class Mortgage {
    @Id
    @GeneratedValue
    private int mortgageId;
    @Column
    private int customerId;
    //抵押物类型：1/房；2/车；3/保单；
    @Column
    private int mortgageType;
    //抵押物所在区域
    @Column
    private int estateArea;
    @Column
    private BigDecimal estatePrice;
    @Column
    private int estateType;
    @Column
    private int estateAge;
    @Column
    private Date createTime;
    @Column
    private int creator;
    @Column
    private Date updateTime;
    @Column
    private int updator;

    public int getMortgageId() {
        return mortgageId;
    }

    public void setMortgageId(int mortgageId) {
        this.mortgageId = mortgageId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getMortgageType() {
        return mortgageType;
    }

    public void setMortgageType(int mortgageType) {
        this.mortgageType = mortgageType;
    }

    public int getEstateArea() {
        return estateArea;
    }

    public void setEstateArea(int estateArea) {
        this.estateArea = estateArea;
    }

    public BigDecimal getEstatePrice() {
        return estatePrice;
    }

    public void setEstatePrice(BigDecimal estatePrice) {
        this.estatePrice = estatePrice;
    }

    public int getEstateType() {
        return estateType;
    }

    public void setEstateType(int estateType) {
        this.estateType = estateType;
    }

    public int getEstateAge() {
        return estateAge;
    }

    public void setEstateAge(int estateAge) {
        this.estateAge = estateAge;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getUpdator() {
        return updator;
    }

    public void setUpdator(int updator) {
        this.updator = updator;
    }
}
