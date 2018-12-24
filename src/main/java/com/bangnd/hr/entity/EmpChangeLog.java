package com.bangnd.hr.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="t_hr_emp_log")
public class EmpChangeLog {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private long empId;

    //变更前部门
    @Column
    private long beforeDeptId;

    //变更后部门
    @Column
    private long afterDeptId;

    //变更前岗位
    @Column
    private long beforePostId;

    //变更后岗位
    @Column
    private long afterPostId;

    //变更前管理职级
    @Column
    private int beforeManageGrade;

    //变更后管理职级
    @Column
    private int afterManageGrade;

    //变更前技术职级
    @Column
    private int beforeTechGrade;

    //变更后技术职级
    @Column
    private int afterTechGrade;

    //变更前从业年限
    @Column
    private float beforEmploymentTime;

    //变更后从业年限
    @Column
    private float afterEmploymentTime;

    //变更前工资
    @Column
    private BigDecimal beforeSalary;

    //变更后工资
    @Column
    private BigDecimal afterSalary;

    //变更原因
    @Column
    private int changeCause;

    @Column
    private Date changeValidDate;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public long getBeforeDeptId() {
        return beforeDeptId;
    }

    public void setBeforeDeptId(long beforeDeptId) {
        this.beforeDeptId = beforeDeptId;
    }

    public long getAfterDeptId() {
        return afterDeptId;
    }

    public void setAfterDeptId(long afterDeptId) {
        this.afterDeptId = afterDeptId;
    }

    public long getBeforePostId() {
        return beforePostId;
    }

    public void setBeforePostId(long beforePostId) {
        this.beforePostId = beforePostId;
    }

    public long getAfterPostId() {
        return afterPostId;
    }

    public void setAfterPostId(long afterPostId) {
        this.afterPostId = afterPostId;
    }

    public int getBeforeManageGrade() {
        return beforeManageGrade;
    }

    public void setBeforeManageGrade(int beforeManageGrade) {
        this.beforeManageGrade = beforeManageGrade;
    }

    public int getAfterManageGrade() {
        return afterManageGrade;
    }

    public void setAfterManageGrade(int afterManageGrade) {
        this.afterManageGrade = afterManageGrade;
    }

    public int getBeforeTechGrade() {
        return beforeTechGrade;
    }

    public void setBeforeTechGrade(int beforeTechGrade) {
        this.beforeTechGrade = beforeTechGrade;
    }

    public int getAfterTechGrade() {
        return afterTechGrade;
    }

    public void setAfterTechGrade(int afterTechGrade) {
        this.afterTechGrade = afterTechGrade;
    }

    public float getBeforEmploymentTime() {
        return beforEmploymentTime;
    }

    public void setBeforEmploymentTime(float beforEmploymentTime) {
        this.beforEmploymentTime = beforEmploymentTime;
    }

    public float getAfterEmploymentTime() {
        return afterEmploymentTime;
    }

    public void setAfterEmploymentTime(float afterEmploymentTime) {
        this.afterEmploymentTime = afterEmploymentTime;
    }

    public BigDecimal getBeforeSalary() {
        return beforeSalary;
    }

    public void setBeforeSalary(BigDecimal beforeSalary) {
        this.beforeSalary = beforeSalary;
    }

    public BigDecimal getAfterSalary() {
        return afterSalary;
    }

    public void setAfterSalary(BigDecimal afterSalary) {
        this.afterSalary = afterSalary;
    }

    public int getChangeCause() {
        return changeCause;
    }

    public void setChangeCause(int changeCause) {
        this.changeCause = changeCause;
    }

    public Date getChangeValidDate() {
        return changeValidDate;
    }

    public void setChangeValidDate(Date changeValidDate) {
        this.changeValidDate = changeValidDate;
    }

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
