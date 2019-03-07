package com.bangnd.hr.form;

import javax.persistence.*;
import java.util.*;

public class EmployeeSearchForm {
    @Column
    public String name;
    @Column
    public String birthday;
    @Column
    public String city;
    @Column
    public String dept;
    @Column
    public String manageGrade;
    @Column
    public String techGrade;
    @Column
    public String phone;

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getCity() {
        return city;
    }

    public String getDept() {
        return dept;
    }

    public String getManageGrade() {
        return manageGrade;
    }

    public String getTechGrade() {
        return techGrade;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setManageGrade(String manageGrade) {
        this.manageGrade = manageGrade;
    }

    public void setTechGrade(String techGrade) {
        this.techGrade = techGrade;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}