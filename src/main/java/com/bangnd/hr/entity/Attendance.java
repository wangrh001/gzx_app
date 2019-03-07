package com.bangnd.hr.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "t_hr_attendance")
public class Attendance {
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
    public int empId;
    @Column
    public String empName;
    @Column
    public String month;
    @Column
    public Date workDay;
    @Column
    public Date checkTime;
    @Column
    public int askType;
    @Column
    public Date askBeginTime;
    @Column
    public Date askEndTime;

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getMonth() {
        return month;
    }

    public Date getWorkDay() {
        return workDay;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public int getAskType() {
        return askType;
    }

    public Date getAskBeginTime() {
        return askBeginTime;
    }

    public Date getAskEndTime() {
        return askEndTime;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setWorkDay(Date workDay) {
        this.workDay = workDay;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public void setAskType(int askType) {
        this.askType = askType;
    }

    public void setAskBeginTime(Date askBeginTime) {
        this.askBeginTime = askBeginTime;
    }

    public void setAskEndTime(Date askEndTime) {
        this.askEndTime = askEndTime;
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