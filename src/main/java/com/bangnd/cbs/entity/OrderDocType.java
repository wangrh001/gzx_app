package com.bangnd.cbs.entity;

import javax.persistence.*;

@Entity
@Table(name="cfg_order_doc_type")
public class OrderDocType {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String chName;
    @Column
    private String enName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChName() {
        return chName;
    }

    public void setChName(String chName) {
        this.chName = chName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }
}
