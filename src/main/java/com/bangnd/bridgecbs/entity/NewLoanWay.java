package com.bangnd.bridgecbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cfg_new_load_way")
public class NewLoanWay {
    @Id
    private int id;
    //1、按揭；2、组合贷；3、公积金贷；4、一次性付款；5、经营贷；6、消费贷
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
