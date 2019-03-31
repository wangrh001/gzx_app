package com.bangnd.cbs.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="t_cbs_order_log")
public class OrderLog {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private long orderId;

    @Column
    private long orderProductId;

    @Column
    private long userId;

    @Column
    private long buttonId;

    @Column
    private Date operatorTime;

    @Column
    private String actionDesc;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(long orderProductId) {
        this.orderProductId = orderProductId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getButtonId() {
        return buttonId;
    }

    public void setButtonId(long buttonId) {
        this.buttonId = buttonId;
    }

    public Date getOperatorTime() {
        return operatorTime;
    }

    public void setOperatorTime(Date operatorTime) {
        this.operatorTime = operatorTime;
    }

    public String getActionDesc() {
        return actionDesc;
    }

    public void setActionDesc(String actionDesc) {
        this.actionDesc = actionDesc;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdator() {
        return updator;
    }

    public void setUpdator(Integer updator) {
        this.updator = updator;
    }
}
