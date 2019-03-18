package com.bangnd.batch.vo;

import javax.persistence.Column;
import java.util.Date;

public class BTaskVO {
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
    public int batchId;
    @Column
    public Date startTime;
    @Column
    public Date endTime;
    @Column
    public String resultName;
    @Column
    public String errorDesc;

    public String getBatchName() {
        return batchName;
    }

    public int getBatchId() {
        return batchId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public String getResultName() {
        return resultName;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setResultName(String resultName) {
        this.resultName = resultName;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }
}