package com.bangnd.sales.form;

import javax.persistence.Column;
import java.util.Date;

public class TelSalesSearchForm {
    @Column
    public String phone;
    @Column
    public Date taskDateEnd;
    @Column
    public Date taskDateStart;

    public String getPhone() {
        return phone;
    }

    public Date getTaskDateEnd() {
        return taskDateEnd;
    }

    public Date getTaskDateStart() {
        return taskDateStart;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setTaskDateEnd(Date taskDateEnd) {
        this.taskDateEnd = taskDateEnd;
    }

    public void setTaskDateStart(Date taskDateStart) {
        this.taskDateStart = taskDateStart;
    }
}