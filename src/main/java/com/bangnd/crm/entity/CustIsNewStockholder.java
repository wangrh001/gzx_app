package com.bangnd.crm.entity;

import javax.persistence.*;

@Entity
@Table(name = "cfg_cust_isNewStockholder")
public class CustIsNewStockholder {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
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