package com.bangnd.sales.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "t_sales_commission")
public class Commission {
    @Id
    @GeneratedValue
    public long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public int businessType;

    @Column
    public int productId;
    @Column
    public int level;
    @Column
    public int type;
    @Column
    public int way;
    @Column
    public BigDecimal percent;
    @Column
    public BigDecimal sum;
    @Column
    public int baseType;
    @Column
    public int channelType;
    @Column
    public Date startDate;
    @Column
    public Date endDate;

    public int getBusinessType() {
        return businessType;
    }

    public int getProductId() {
        return productId;
    }

    public int getLevel() {
        return level;
    }

    public int getType() {
        return type;
    }

    public int getWay() {
        return way;
    }

    public BigDecimal getPercent() {
        return percent;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public int getBaseType() {
        return baseType;
    }

    public int getChannelType() {
        return channelType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setBusinessType(int businessType) {
        this.businessType = businessType;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setWay(int way) {
        this.way = way;
    }

    public void setPercent(BigDecimal percent) {
        this.percent = percent;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public void setBaseType(int baseType) {
        this.baseType = baseType;
    }

    public void setChannelType(int channelType) {
        this.channelType = channelType;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Column
    private int state;
    @Column
    private long creator;
    @Column
    private Date createTime;
    @Column
    private long updator;
    @Column
    private Date updateTime;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public long getCreator() {
        return creator;
    }

    public void setCreator(long creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public long getUpdator() {
        return updator;
    }

    public void setUpdator(long updator) {
        this.updator = updator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}