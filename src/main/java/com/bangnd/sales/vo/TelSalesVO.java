package com.bangnd.sales.vo;

import javax.persistence.*;
import java.util.*;
import java.math.BigDecimal;

public class TelSalesVO {
    @Column
    public long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}