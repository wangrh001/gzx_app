package com.bangnd.cbs.entity;

import javax.persistence.*;

@Entity
@Table(name="cfg_cbs_payInterest_way")
public class PayInterestWay {
    @Id
    @GeneratedValue
    private int id;

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
