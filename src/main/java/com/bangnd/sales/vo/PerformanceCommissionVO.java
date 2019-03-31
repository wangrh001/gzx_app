package com.bangnd.sales.vo;

import javax.persistence.Column;
import java.math.BigDecimal;

public class PerformanceCommissionVO {
    @Column
    public long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public String month;
    @Column
    public String salerName;

    @Column
    public long orderProdId;
    @Column
    public BigDecimal commission;

    @Column
    public BigDecimal minCommission;
    @Column
    public BigDecimal maxCommission;
    @Column
    public BigDecimal performance;
    @Column
    private BigDecimal interest;
    @Column
    public String processName;

    public String getMonth() {
        return month;
    }

    public String getSalerName() {
        return salerName;
    }

    public void setSalerName(String salerName) {
        this.salerName = salerName;
    }

    public long getOrderProdId() {
        return orderProdId;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public BigDecimal getPerformance() {
        return performance;
    }

    public String getProcessName() {
        return processName;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setOrderProdId(long orderProdId) {
        this.orderProdId = orderProdId;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public void setPerformance(BigDecimal performance) {
        this.performance = performance;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
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