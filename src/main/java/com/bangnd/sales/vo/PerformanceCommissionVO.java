package com.bangnd.sales.vo;

import javax.persistence.*;
import java.util.*;
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
    public long agentId;
    @Column
    public String month;
    @Column
    public String agentName;
    @Column
    public BigDecimal commission;
    @Column
    public BigDecimal performance;
    @Column
    public String processName;

    public long getAgentId() {
        return agentId;
    }

    public String getMonth() {
        return month;
    }

    public String getAgentName() {
        return agentName;
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

    public void setAgentId(long agentId) {
        this.agentId = agentId;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
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