package com.bangnd.finance.entity;

import javax.persistence.*;

@Entity
@Table(name = "cfg_account_balance")
public class AccountBalance {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String name;

    //1、资产类；2、负债类；3、所有这权益类；4、成本类；5、损益类
    @Column
    private int type;

    //科目编码
    @Column
    private String code;


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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}