package com.bangnd.mis.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "t_mis_task")
public class Task {
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
    public String taskName;
    @Column
    public int type;
    @Column
    public String taskDesc;
    @Column
    public int taskPeriod;
    @Column
    public Date beginDate;
    @Column
    public int endDate;
    @Column
    public int employeeId;
    @Column
    public BigDecimal amount;
    @Column
    public int taskState;
    @Column
    public BigDecimal completeAmount;

    public String getTaskName() {
        return taskName;
    }

    public int getType() {
        return type;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public int getTaskPeriod() {
        return taskPeriod;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int getTaskState() {
        return taskState;
    }

    public BigDecimal getCompleteAmount() {
        return completeAmount;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public void setTaskPeriod(int taskPeriod) {
        this.taskPeriod = taskPeriod;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setTaskState(int taskState) {
        this.taskState = taskState;
    }

    public void setCompleteAmount(BigDecimal completeAmount) {
        this.completeAmount = completeAmount;
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