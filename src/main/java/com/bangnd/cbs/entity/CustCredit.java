package com.bangnd.cbs.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

//客户信用表
@Entity
@Table(name="t_cust_credit")
public class CustCredit {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private long customerId;

    //近半年逾期次数（逾期一期就算一次）
    @Column
    private int DTimes6M;
    //两年内逾期次数（逾期一期就算一次）
    @Column
    private int DTimes2Y;
    //近五年内逾期次数
    @Column
    private int DTimes5Y;

    //两年内连续逾期两期次数
    @Column
    private int contD2Times2Y;
    //两年内最大逾期天数
    @Column
    private int DDays2Y;
    //两年内连续逾期三期次数
    @Column
    private int contD3Times2Y;
    //两年内连续逾期四期次数
    @Column
    private int contD4Times2Y;

    //一年内连续逾期三期次数
    @Column
    private int contD3Times1Y;

    //半年内连续逾期二期次数
    @Column
    private int contD2Times6M;


    //五年内连续逾期三期次数
    @Column
    private int contD3Times5Y;

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

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public int getDTimes6M() {
        return DTimes6M;
    }

    public void setDTimes6M(int DTimes6M) {
        this.DTimes6M = DTimes6M;
    }

    public int getDTimes2Y() {
        return DTimes2Y;
    }

    public void setDTimes2Y(int DTimes2Y) {
        this.DTimes2Y = DTimes2Y;
    }

    public int getDTimes5Y() {
        return DTimes5Y;
    }

    public void setDTimes5Y(int DTimes5Y) {
        this.DTimes5Y = DTimes5Y;
    }

    public int getContD2Times2Y() {
        return contD2Times2Y;
    }

    public void setContD2Times2Y(int contD2Times2Y) {
        this.contD2Times2Y = contD2Times2Y;
    }

    public int getDDays2Y() {
        return DDays2Y;
    }

    public void setDDays2Y(int DDays2Y) {
        this.DDays2Y = DDays2Y;
    }

    public int getContD4Times2Y() {
        return contD4Times2Y;
    }

    public void setContD4Times2Y(int contD4Times2Y) {
        this.contD4Times2Y = contD4Times2Y;
    }

    public int getContD3Times1Y() {
        return contD3Times1Y;
    }

    public void setContD3Times1Y(int contD3Times1Y) {
        this.contD3Times1Y = contD3Times1Y;
    }

    public int getContD2Times6M() {
        return contD2Times6M;
    }

    public void setContD2Times6M(int contD2Times6M) {
        this.contD2Times6M = contD2Times6M;
    }

    public int getContD3Times2Y() {
        return contD3Times2Y;
    }

    public void setContD3Times2Y(int contD3Times2Y) {
        this.contD3Times2Y = contD3Times2Y;
    }

    public int getContD3Times5Y() {
        return contD3Times5Y;
    }

    public void setContD3Times5Y(int contD3Times5Y) {
        this.contD3Times5Y = contD3Times5Y;
    }

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
