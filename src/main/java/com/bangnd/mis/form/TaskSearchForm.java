package com.bangnd.mis.form;

import javax.persistence.Column;

public class TaskSearchForm {
    @Column
    public String taskName;
    @Column
    public String type;
    @Column
    public String taskPeriod;
    @Column
    public String taskState;

    public String getTaskName() {
        return taskName;
    }

    public String getType() {
        return type;
    }

    public String getTaskPeriod() {
        return taskPeriod;
    }

    public String getTaskState() {
        return taskState;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTaskPeriod(String taskPeriod) {
        this.taskPeriod = taskPeriod;
    }

    public void setTaskState(String taskState) {
        this.taskState = taskState;
    }
}