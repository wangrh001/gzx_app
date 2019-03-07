package com.bangnd.sales.form;

import javax.persistence.*;
import java.util.*;

public class PerformanceCommissionSearchForm {
    @Column
    public String month;
    @Column
    public String agentName;
    @Column
    public String process;

    public String getMonth() {
        return month;
    }

    public String getAgentName() {
        return agentName;
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

    public void setProcess(String process) {
        this.process = process;
    }
}