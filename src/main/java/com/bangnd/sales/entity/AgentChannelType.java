package com.bangnd.sales.entity;

import javax.persistence.*;

@Entity
@Table(name = "cfg_agent_channelType")
public class AgentChannelType {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String name;
    //1、内部；2、外部
    @Column
    private int type;

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}