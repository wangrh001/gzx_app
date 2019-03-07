package com.bangnd.hr.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "t_hr_salary")
public class Salary {
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
    public BigDecimal basicSalary;
    @Column
    public BigDecimal currentSalary;
    @Column
    public int extendState;
    @Column
    public Date extendDate;

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getMonth() {
        return month;
    }

    public BigDecimal getBasicSalary() {
        return basicSalary;
    }

    public BigDecimal getCurrentSalary() {
        return currentSalary;
    }

    public int getExtendState() {
        return extendState;
    }

    public Date getExtendDate() {
        return extendDate;
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

    public void setBasicSalary(BigDecimal basicSalary) {
        this.basicSalary = basicSalary;
    }

    public void setCurrentSalary(BigDecimal currentSalary) {
        this.currentSalary = currentSalary;
    }

    public void setExtendState(int extendState) {
        this.extendState = extendState;
    }

    public void setExtendDate(Date extendDate) {
        this.extendDate = extendDate;
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