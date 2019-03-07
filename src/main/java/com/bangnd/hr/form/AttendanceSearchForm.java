package com.bangnd.hr.form;

import javax.persistence.*;
import java.util.*;

public class AttendanceSearchForm {
    @Column
    public String empName;
    @Column
    public String month;
    @Column
    public Date workDayEnd;
    @Column
    public Date workDayStart;
    @Column
    public String askType;

    public String getEmpName() {
        return empName;
    }

    public String getMonth() {
        return month;
    }

    public Date getWorkDayEnd() {
        return workDayEnd;
    }

    public Date getWorkDayStart() {
        return workDayStart;
    }

    public String getAskType() {
        return askType;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setWorkDayEnd(Date workDayEnd) {
        this.workDayEnd = workDayEnd;
    }

    public void setWorkDayStart(Date workDayStart) {
        this.workDayStart = workDayStart;
    }

    public void setAskType(String askType) {
        this.askType = askType;
    }
}