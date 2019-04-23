package com.bangnd.cbs.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="t_cbs_certi_log")
public class CertificateLog {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private long certiId;

    @Column
    private int optType;

    @Column
    private Date optTime;

    @Column
    private long operator;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getOptType() {
        return optType;
    }

    public void setOptType(int optType) {
        this.optType = optType;
    }

    public Date getOptTime() {
        return optTime;
    }

    public void setOptTime(Date optTime) {
        this.optTime = optTime;
    }

    public long getOperator() {
        return operator;
    }

    public void setOperator(long operator) {
        this.operator = operator;
    }

    public long getCertiId() {
        return certiId;
    }

    public void setCertiId(long certiId) {
        this.certiId = certiId;
    }
}
