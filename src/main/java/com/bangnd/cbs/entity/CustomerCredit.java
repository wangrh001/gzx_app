package com.bangnd.cbs.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="t_cust_credit")
public class CustomerCredit {
    @Id
    @GeneratedValue
    private long id;

    //两年内是否有连续两个月逾期
    @Column
    private int continuousDelay;
    //24个月累计逾期
    @Column
    private int totalDelay;
    //贷款单笔总逾期
    @Column
    private int maxDelay;
    //信用卡当前冻结金额
    @Column
    private BigDecimal freezeAmount;
    //信用扩展字段1
    @Column
    private int extend1;
    @Column
    private int extend2;
    @Column
    private int extend3;
    @Column
    private int extend4;


    @Column
    private Date createTime;
    @Column
    private int creator;
    @Column
    private Date updateTime;
    @Column
    private int updator;


    public int getExtend1() {
        return extend1;
    }

    public void setExtend1(int extend1) {
        this.extend1 = extend1;
    }

    public int getExtend2() {
        return extend2;
    }

    public void setExtend2(int extend2) {
        this.extend2 = extend2;
    }

    public int getExtend3() {
        return extend3;
    }

    public void setExtend3(int extend3) {
        this.extend3 = extend3;
    }

    public int getExtend4() {
        return extend4;
    }

    public void setExtend4(int extend4) {
        this.extend4 = extend4;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getContinuousDelay() {
        return continuousDelay;
    }

    public void setContinuousDelay(int continuousDelay) {
        this.continuousDelay = continuousDelay;
    }

    public int getTotalDelay() {
        return totalDelay;
    }

    public void setTotalDelay(int totalDelay) {
        this.totalDelay = totalDelay;
    }

    public int getMaxDelay() {
        return maxDelay;
    }

    public void setMaxDelay(int maxDelay) {
        this.maxDelay = maxDelay;
    }

    public BigDecimal getFreezeAmount() {
        return freezeAmount;
    }

    public void setFreezeAmount(BigDecimal freezeAmount) {
        this.freezeAmount = freezeAmount;
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
