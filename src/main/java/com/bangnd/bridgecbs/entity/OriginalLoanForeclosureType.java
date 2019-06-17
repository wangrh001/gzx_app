package com.bangnd.bridgecbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cfg_original_loan_foreclosure_type")
public class OriginalLoanForeclosureType {
    @Id
    private int id;
    //1、柜台手动扣款；2、系统自动扣款；3、客户经理手动操作；4、APP操作扣款；
    // 5、网银操作扣款；6、电话银行预约扣款；7、预存系统扣款
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
