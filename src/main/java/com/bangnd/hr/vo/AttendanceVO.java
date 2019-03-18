package com.bangnd.hr.vo;

import javax.persistence.Column;
import java.util.Date;

public class AttendanceVO {
    @Column
    public long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public String empName;
    @Column
    public Date workDay;
    @Column
    public String askTypeName;

    public String getEmpName() {
        return empName;
    }

    public Date getWorkDay() {
        return workDay;
    }

    public String getAskTypeName() {
        return askTypeName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setWorkDay(Date workDay) {
        this.workDay = workDay;
    }

    public void setAskTypeName(String askTypeName) {
        this.askTypeName = askTypeName;
    }
}