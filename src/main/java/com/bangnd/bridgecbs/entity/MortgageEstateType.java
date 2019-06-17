package com.bangnd.bridgecbs.entity;

import javax.persistence.*;

@Entity
@Table(name = "cfg_bridge_estate_type")
public class MortgageEstateType {
    @Id
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
