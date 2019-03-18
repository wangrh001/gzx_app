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
    public long agentId;
    @Column
    public String month;
    @Column
    public String agentName;
    @Column
    public long employeeId;
    @Column
    public String employeeName;
    @Column
    public long orderProdId;
    @Column
    public BigDecimal commission;
    @Column
    public BigDecimal performance;
    @Column
    public int process;

    public long getAgentId() {
        return agentId;
    }

    public String getMonth() {
        return month;
    }

    public String getAgentName() {
        return agentName;
    }

    public long getEmployeeId() {
        return employeeId;
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

    public int getProcess() {
        return process;
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

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
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
}