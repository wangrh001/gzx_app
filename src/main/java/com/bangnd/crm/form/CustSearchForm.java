package com.bangnd.crm.form;

import javax.persistence.Column;

public class CustSearchForm {
    @Column
    public String name;
    @Column
    public String birthday;
    @Column
    public String phone;
    @Column
    public String city;
    @Column
    public String sex;
    @Column
    public String salesState;
    @Column
    public String infoOriginal;
    @Column
    public String whyBorrow;
    @Column
    public String job;

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    public String getSex() {
        return sex;
    }

    public String getSalesState() {
        return salesState;
    }

    public String getInfoOriginal() {
        return infoOriginal;
    }

    public String getWhyBorrow() {
        return whyBorrow;
    }

    public String getJob() {
        return job;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setSalesState(String salesState) {
        this.salesState = salesState;
    }

    public void setInfoOriginal(String infoOriginal) {
        this.infoOriginal = infoOriginal;
    }

    public void setWhyBorrow(String whyBorrow) {
        this.whyBorrow = whyBorrow;
    }

    public void setJob(String job) {
        this.job = job;
    }
}