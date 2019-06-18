package com.bangnd.bridgecbs.entity;

import javax.persistence.*;

@Entity
@Table(name="cfg_original_loan_type")
public class OriginalLoanType {
    @Id
    private int id;
    //1、抵押贷；2、装修贷；3、公积金
    @Column
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}