package com.bangnd.crm.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "t_crm_cust")
public class Cust {
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
    public String phone;
    @Column
    public int city;
    @Column
    public String address;
    @Column
    public String cardNo;
    @Column
    public int sex;
    @Column
    public int salesState;
    @Column
    public int infoOriginal;
    @Column
    public int whyBorrow;
    @Column
    public int job;
    @Column
    public int isNewStockholder;
    @Column
    public int beStockholderMonths;

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getCertiCode() {
        return certiCode;
    }

    public String getPhone() {
        return phone;
    }

    public int getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getCardNo() {
        return cardNo;
    }

    public int getSex() {
        return sex;
    }

    public int getSalesState() {
        return salesState;
    }

    public int getInfoOriginal() {
        return infoOriginal;
    }

    public int getWhyBorrow() {
        return whyBorrow;
    }

    public int getJob() {
        return job;
    }

    public int getIsNewStockholder() {
        return isNewStockholder;
    }

    public int getBeStockholderMonths() {
        return beStockholderMonths;
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setSalesState(int salesState) {
        this.salesState = salesState;
    }

    public void setInfoOriginal(int infoOriginal) {
        this.infoOriginal = infoOriginal;
    }

    public void setWhyBorrow(int whyBorrow) {
        this.whyBorrow = whyBorrow;
    }

    public void setJob(int job) {
        this.job = job;
    }

    public void setIsNewStockholder(int isNewStockholder) {
        this.isNewStockholder = isNewStockholder;
    }

    public void setBeStockholderMonths(int beStockholderMonths) {
        this.beStockholderMonths = beStockholderMonths;
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