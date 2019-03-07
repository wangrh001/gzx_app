package com.bangnd.cbs.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_bank")
public class Bank {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private int orgType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrgType() {
        return orgType;
    }

    public void setOrgType(int orgType) {
        this.orgType = orgType;
    }
}
