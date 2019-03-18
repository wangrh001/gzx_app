package com.bangnd.sales.form;

import javax.persistence.Column;

public class PerformanceCommissionSearchForm {
    @Column
    public String month;
    @Column
    public String agentName;
    @Column
    public String employeeName;
    @Column
    public String process;

    public String getMonth() {
        return month;
    }

    public String getAgentName() {
        return agentName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getProcess() {
        return process;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setProcess(String process) {
        this.process = process;
    }
}