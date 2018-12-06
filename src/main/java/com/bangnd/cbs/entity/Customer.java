package com.bangnd.cbs.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="t_customer")
public class Customer {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private long orderId;
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private Date birthday;
    @Column
    private String certiCode;
    @Column
    private String address;
    @Column
    private String phone;
    @Column
    private int gender;
    @Column
    private String job;
    @Column
    private long custState;
    //是不是新加入股东;Y、是；N、否
    @Column
    private String isNewStockholder;
    //成为新股东月数
    @Column
    private int beStockholderMonths;
    @Column(nullable = true, unique = false)
    private Date createTime;
    @Column(nullable = true, unique = false)
    private Integer creator;
    @Column(nullable = true, unique = false)
    private Date updateTime;
    @Column(nullable = true, unique = false)
    private Integer updator;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdator() {
        return updator;
    }

    public void setUpdator(Integer updator) {
        this.updator = updator;
    }

    public String getCertiCode() {
        return certiCode;
    }

    public void setCertiCode(String certiCode) {
        this.certiCode = certiCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCustState() {
        return custState;
    }

    public void setCustState(long custState) {
        this.custState = custState;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getIsNewStockholder() {
        return isNewStockholder;
    }

    public void setIsNewStockholder(String isNewStockholder) {
        this.isNewStockholder = isNewStockholder;
    }

    public int getBeStockholderMonths() {
        return beStockholderMonths;
    }

    public void setBeStockholderMonths(int beStockholderMonths) {
        this.beStockholderMonths = beStockholderMonths;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
}
