package com.bangnd.sales.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "t_sales_performanceCommission")
public class PerformanceCommission {
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
    public long salerId;
    @Column
    public String month;
    @Column
    public String salerName;
    @Column
    public BigDecimal commission;
    @Column
    public BigDecimal minCommission;
    @Column
    public BigDecimal maxCommission;

    @Column
    public BigDecimal performance;
    @Column
    public BigDecimal interest;
    @Column
    public int process;

    public long getSalerId() {
        return salerId;
    }

    public void setSalerId(long salerId) {
        this.salerId = salerId;
    }

    public String getSalerName() {
        return salerName;
    }

    public void setSalerName(String salerName) {
        this.salerName = salerName;
    }

    public String getMonth() {
        return month;
    }


    public BigDecimal getCommission() {
        return commission;
    }

    public BigDecimal getPerformance() {
        return performance;
    }

    public int getProcess() {
        return process;
    }


    public void setMonth(String month) {
        this.month = month;
    }


    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public void setPerformance(BigDecimal performance) {
        this.performance = performance;
    }

    public void setProcess(int process) {
        this.process = process;
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

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getMinCommission() {
        return minCommission;
    }

    public void setMinCommission(BigDecimal minCommission) {
        this.minCommission = minCommission;
    }

    public BigDecimal getMaxCommission() {
        return maxCommission;
    }

    public void setMaxCommission(BigDecimal maxCommission) {
        this.maxCommission = maxCommission;
    }
}