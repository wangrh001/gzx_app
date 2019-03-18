package com.bangnd.batch.form;

import javax.persistence.Column;

public class BTaskSearchForm {
    @Column
    public String batchName;
    @Column
    public String result;

    public String getBatchName() {
        return batchName;
    }

    public String getResult() {
        return result;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public void setResult(String result) {
        this.result = result;
    }
}