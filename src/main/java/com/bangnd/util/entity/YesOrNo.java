package com.bangnd.util.entity;

import javax.persistence.*;

@Entity
@Table(name = "cfg_yes_no")
public class YesOrNo {
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