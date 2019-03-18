package com.bangnd.hr.form;

import javax.persistence.Column;

public class SalarySearchForm {
    @Column
    public String empName;
    @Column
    public String month;
    @Column
    public String extendState;

    public String getEmpName() {
        return empName;
    }

    public String getMonth() {
        return month;
    }

    public String getExtendState() {
        return extendState;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setExtendState(String extendState) {
        this.extendState = extendState;
    }
}