package com.bangnd.hr.vo;

import javax.persistence.Column;
import java.math.BigDecimal;

public class SalaryVO {
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
    public BigDecimal basicSalary;
    @Column
    public BigDecimal currentSalary;
    @Column
    public String extendStateName;

    public String getEmpName() {
        return empName;
    }

    public BigDecimal getBasicSalary() {
        return basicSalary;
    }

    public BigDecimal getCurrentSalary() {
        return currentSalary;
    }

    public String getExtendStateName() {
        return extendStateName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setBasicSalary(BigDecimal basicSalary) {
        this.basicSalary = basicSalary;
    }

    public void setCurrentSalary(BigDecimal currentSalary) {
        this.currentSalary = currentSalary;
    }

    public void setExtendStateName(String extendStateName) {
        this.extendStateName = extendStateName;
    }
}