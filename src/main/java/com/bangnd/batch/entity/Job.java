package com.bangnd.batch.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "t_batch_job")
public class Job {
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
    public String batchName;
    @Column
    public int type;
    @Column
    public int periodNum;
    @Column
    public Date lastTime;
    @Column
    public Date startTime;
    @Column
    public Date nextTime;

    public String getBatchName() {
        return batchName;
    }

    public int getType() {
        return type;
    }

    public int getPeriodNum() {
        return periodNum;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getNextTime() {
        return nextTime;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setPeriodNum(int periodNum) {
        this.periodNum = periodNum;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setNextTime(Date nextTime) {
        this.nextTime = nextTime;
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