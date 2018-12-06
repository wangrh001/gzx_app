package com.bangnd.cbs.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

//客户公司表
@Entity
@Table(name="t_cust_company")
public class CustCompany {
    @Id
    @GeneratedValue
    private long companyId;

    @Column
    private String companyName;

    //注册资金
    @Column
    private BigDecimal Capital;

    //注册日期
    @Column
    private Date registeredDate;

    //贷款人在该公司占股
    @Column
    private BigDecimal sharePercent;

}
