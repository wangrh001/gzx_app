package com.bangnd.hr.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "t_hr_employee")
public class Employee {
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
    public String name;
    @Column
    public Date birthday;
    @Column
    public String certiCode;
    @Column
    public int city;
    @Column
    public int dept;
    @Column
    public int manageGrade;
    @Column
    public BigDecimal salary;
    @Column
    public int techGrade;
    @Column
    public Date hiredate;
    @Column
    public Date leavedate;
    @Column
    public String phone;
    @Column
    public String address;
    @Column
    public String cardNo;
    @Column
    public String emgName;
    @Column
    public String emgPhone;
    @Column
    public int position;

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getCertiCode() {
        return certiCode;
    }

    public int getCity() {
        return city;
    }

    public int getDept() {
        return dept;
    }

    public int getManageGrade() {
        return manageGrade;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public int getTechGrade() {
        return techGrade;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public Date getLeavedate() {
        return leavedate;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCardNo() {
        return cardNo;
    }

    public String getEmgName() {
        return emgName;
    }

    public String getEmgPhone() {
        return emgPhone;
    }

    public int getPosition() {
        return position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setCertiCode(String certiCode) {
        this.certiCode = certiCode;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public void setDept(int dept) {
        this.dept = dept;
    }

    public void setManageGrade(int manageGrade) {
        this.manageGrade = manageGrade;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setTechGrade(int techGrade) {
        this.techGrade = techGrade;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public void setLeavedate(Date leavedate) {
        this.leavedate = leavedate;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public void setEmgName(String emgName) {
        this.emgName = emgName;
    }

    public void setEmgPhone(String emgPhone) {
        this.emgPhone = emgPhone;
    }

    public void setPosition(int position) {
        this.position = position;
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