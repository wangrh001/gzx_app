package com.bangnd.cbs.entity;

import javax.persistence.*;
import java.util.Date;

//订单参数表

/**
 * @author kevin.wang
 * @version 1.0
 * 可以格式化到 customer、custMortgage、custCredit、custCompany这些对象的参数，都放到这些类中
 * 不好格式化的参数，都放到这个表中
 */
@Entity
@Table(name = "t_order_paras")
public class OrderParas {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private long orderId;

    @Column
    private long paraId;

    @Column
    private String paraValue;

    @Column
    private int state;

    @Column(nullable = true, unique = false)
    private Date createTime;
    @Column(nullable = true, unique = false)
    private Integer creator;
    @Column(nullable = true, unique = false)
    private Date updateTime;
    @Column(nullable = true, unique = false)
    private Integer updator;

}
