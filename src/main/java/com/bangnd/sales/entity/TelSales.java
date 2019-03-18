package com.bangnd.sales.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_sales_telSales")
public class TelSales {
    @Id
    @GeneratedValue
    public long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public String phone;
    @Column
    public Date taskDate;
    @Column
    public int result;
    @Column
    public int taskDelay;
    @Column
    public String markDesc;
    @Column
    public String histDesc;

    public String getPhone() {
        return phone;
    }

    public Date getTaskDate() {
        return taskDate;
    }

    public int getResult() {
        return result;
    }

    public int getTaskDelay() {
        return taskDelay;
    }

    public String getMarkDesc() {
        return markDesc;
    }

    public String getHistDesc() {
        return histDesc;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void setTaskDelay(int taskDelay) {
        this.taskDelay = taskDelay;
    }

    public void setMarkDesc(String markDesc) {
        this.markDesc = markDesc;
    }

    public void setHistDesc(String histDesc) {
        this.histDesc = histDesc;
    }

    @Column
    private int state;
    @Column
    private long creator;
    @Column
    private Date createTime;
    @Column
    private long updator;
    @Column
    private Date updateTime;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public long getCreator() {
        return creator;
    }

    public void setCreator(long creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public long getUpdator() {
        return updator;
    }

    public void setUpdator(long updator) {
        this.updator = updator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}