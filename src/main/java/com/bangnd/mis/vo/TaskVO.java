package com.bangnd.mis.vo;

import javax.persistence.Column;
import java.math.BigDecimal;

public class TaskVO {
    @Column
    public long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public String taskName;
    @Column
    public String endDateName;
    @Column
    public BigDecimal amount;
    @Column
    public String taskStateName;
    @Column
    public BigDecimal completeAmount;

    public String getTaskName() {
        return taskName;
    }

    public String getEndDateName() {
        return endDateName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getTaskStateName() {
        return taskStateName;
    }

    public BigDecimal getCompleteAmount() {
        return completeAmount;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setEndDateName(String endDateName) {
        this.endDateName = endDateName;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setTaskStateName(String taskStateName) {
        this.taskStateName = taskStateName;
    }

    public void setCompleteAmount(BigDecimal completeAmount) {
        this.completeAmount = completeAmount;
    }
}