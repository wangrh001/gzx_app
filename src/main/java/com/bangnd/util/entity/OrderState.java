package com.bangnd.util.entity;

import javax.persistence.*;

@Entity
@Table(name="cfg_order_state")
public class OrderState {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
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
