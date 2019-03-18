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
    public String agentName;
    @Column
    public String employeeName;
    @Column
    public long orderProdId;
    @Column
    public BigDecimal commission;
    @Column
    public BigDecimal performance;
    @Column
    public String processName;

    public String getMonth() {
        return month;
    }

    public String getAgentName() {
        return agentName;
    }

    public String getEmployeeName() {
        return employeeName;
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

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
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
}