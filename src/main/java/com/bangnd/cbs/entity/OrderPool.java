package com.bangnd.cbs.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="t_cbs_order_pool")
public class OrderPool {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private long userId;

    @Column
    private long orderId;

    @Column
    private Date intoTime;

    @Column
    private Date leaveTime;

    //1、待处理；2、处理中；3、处理完成
    @Column
    private int doState;

    @Column
    private int positionId;

    //入池次数，即是第几次入池
    @Column
    private int intoPoolNo;

    @Column
    private int state;
    @Column
    private Date createTime;
    @Column
    private int creator;
    @Column
    private Date updateTime;
    @Column
    private int updator;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Date getIntoTime() {
        return intoTime;
    }

    public void setIntoTime(Date intoTime) {
        this.intoTime = intoTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public int getDoState() {
        return doState;
    }

    public void setDoState(int doState) {
        this.doState = doState;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public int getIntoPoolNo() {
        return intoPoolNo;
    }

    public void setIntoPoolNo(int intoPoolNo) {
        this.intoPoolNo = intoPoolNo;
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

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getUpdator() {
        return updator;
    }

    public void setUpdator(int updator) {
        this.updator = updator;
    }
}
