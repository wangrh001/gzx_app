package com.bangnd.hr.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="t_hr_employee")
public class Employee {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private String phone;

    @Column
    private Date birthday;

    @Column
    private String certiCode;

    @Column
    private int provinceId;

    @Column
    private int cityId;

    @Column
    private long userId;

    //入司时间
    @Column
    private Date hiredate;

    //离职时间
    @Column
    private Date leavedate;

    //当前部门
    @Column
    private long currentDeptId;

    //当前岗位
    @Column
    private long postId;

    //当前管理职级
    @Column
    private int currentManageGrade;

    //当前技术职级
    @Column
    private int currentTechGrade;

    //从业年限
    @Column
    private float employmentTime;

    //当前工资
    @Column
    private BigDecimal currentSalary;

    //工资账号
    @Column
    private String cardNo;

    //常住地
    @Column
    private String address;

    //紧急联系人
    @Column
    private String emgName;

    //紧急联系人电话
    private String emgPhone;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCertiCode() {
        return certiCode;
    }

    public void setCertiCode(String certiCode) {
        this.certiCode = certiCode;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Date getLeavedate() {
        return leavedate;
    }

    public void setLeavedate(Date leavedate) {
        this.leavedate = leavedate;
    }

    public long getCurrentDeptId() {
        return currentDeptId;
    }

    public void setCurrentDeptId(long currentDeptId) {
        this.currentDeptId = currentDeptId;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public int getCurrentManageGrade() {
        return currentManageGrade;
    }

    public void setCurrentManageGrade(int currentManageGrade) {
        this.currentManageGrade = currentManageGrade;
    }

    public int getCurrentTechGrade() {
        return currentTechGrade;
    }

    public void setCurrentTechGrade(int currentTechGrade) {
        this.currentTechGrade = currentTechGrade;
    }

    public float getEmploymentTime() {
        return employmentTime;
    }

    public void setEmploymentTime(float employmentTime) {
        this.employmentTime = employmentTime;
    }

    public BigDecimal getCurrentSalary() {
        return currentSalary;
    }

    public void setCurrentSalary(BigDecimal currentSalary) {
        this.currentSalary = currentSalary;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmgName() {
        return emgName;
    }

    public void setEmgName(String emgName) {
        this.emgName = emgName;
    }

    public String getEmgPhone() {
        return emgPhone;
    }

    public void setEmgPhone(String emgPhone) {
        this.emgPhone = emgPhone;
    }
}
