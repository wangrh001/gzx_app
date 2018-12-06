package com.bangnd.cbs.entity;

import javax.persistence.*;

//产品发行银行表
@Entity
@Table(name="t_prod_bank")
public class ProdBank {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String name;

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
}
