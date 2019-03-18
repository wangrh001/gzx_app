package com.bangnd.batch.vo;

import javax.persistence.Column;
import java.util.Date;

public class JobVO {
    @Column
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
    public String typeName;
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

    public String getTypeName() {
        return typeName;
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

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
}