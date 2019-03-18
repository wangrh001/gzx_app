package com.bangnd.batch.form;

import javax.persistence.Column;
import java.util.Date;

public class JobSearchForm {
    @Column
    public String batchName;
    @Column
    public String type;
    @Column
    public Date nextTimeEnd;
    @Column
    public Date nextTimeStart;

    public String getBatchName() {
        return batchName;
    }

    public String getType() {
        return type;
    }

    public Date getNextTimeEnd() {
        return nextTimeEnd;
    }

    public Date getNextTimeStart() {
        return nextTimeStart;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNextTimeEnd(Date nextTimeEnd) {
        this.nextTimeEnd = nextTimeEnd;
    }

    public void setNextTimeStart(Date nextTimeStart) {
        this.nextTimeStart = nextTimeStart;
    }
}