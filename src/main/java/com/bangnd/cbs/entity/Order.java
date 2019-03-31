package com.bangnd.cbs.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "t_cbs_order")
public class Order {
    @Id
    @GeneratedValue
    private long id;

    //需求金额
    @Column
    private BigDecimal demandAmount;

    //可接受利率
    @Column
    private BigDecimal demandInterest=new BigDecimal(0);

    //用款开始时间
    @Column
    private Date demandDate;

    //支付方式，1、等额本息；2、等额本金；3、月息年本
    @Column
    private int demandPayWay=0;

    //周期类型：1、天；2、周；3、月；4、年
    @Column
    private int periodType;

    @Column
    private int periodNum;

    @Column
    private int nextOrgType=0;

    //申请人
    @Column
    @NotEmpty(message="申请人不能为空")
    private String applicantName;

    //申请人电话
    @Column
    @NotEmpty(message="电话不能为空")
    @Length(min=6, message="密码长度不能少于六位")
    private String cellPhone;

    //1、居间业务；2、抵押业务；3、垫资过桥；
    //业务类型
    private int businessType;

    //申请时间
    @Column(nullable = true, unique = false)
    private Date applyTime;
    //销售人员
    @Column(nullable = true, unique = false)
    private long salerId;
    @Column
    private int channelType;

    //服务合同签订时间
    @Column(nullable = true, unique = false)
    private Date signDate;

    //订单产品配置完成时间
    @Column
    private Date checkTime;

    //1、一次性付息；2、按周期付息
    @Column(nullable = true)
    private int payInterestWay=0;

    public BigDecimal getDemandAmount() {
        return demandAmount;
    }

    public void setDemandAmount(BigDecimal demandAmount) {
        this.demandAmount = demandAmount;
    }

    public BigDecimal getDemandInterest() {
        return demandInterest;
    }

    public void setDemandInterest(BigDecimal demandInterest) {
        this.demandInterest = demandInterest;
    }

    public Date getDemandDate() {
        return demandDate;
    }

    public void setDemandDate(Date demandDate) {
        this.demandDate = demandDate;
    }

    public int getDemandPayWay() {
        return demandPayWay;
    }

    public void setDemandPayWay(int demandPayWay) {
        this.demandPayWay = demandPayWay;
    }

    public int getPeriodType() {
        return periodType;
    }

    public void setPeriodType(int periodType) {
        this.periodType = periodType;
    }

    public int getPeriodNum() {
        return periodNum;
    }

    public void setPeriodNum(int periodNum) {
        this.periodNum = periodNum;
    }

    //订单状态：0/建议书阶段；1/收集资料；2/审批通过；3/签订合同；4/支付完成；5/完结；6/订单取消
    @Column(nullable = false, unique = false)
    private int orderState;

    @Column
    private int state;

    @Column(nullable = true, unique = false)
    private Date createTime;
    @Column(nullable = true, unique = false)
    private int creator;
    @Column(nullable = true, unique = false)
    private Date updateTime;
    @Column(nullable = true, unique = false)
    private int updator;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public long getSalerId() {
        return salerId;
    }

    public void setSalerId(long salerId) {
        this.salerId = salerId;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
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

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public void setUpdator(int updator) {
        this.updator = updator;
    }

    public int getBusinessType() {
        return businessType;
    }

    public void setBusinessType(int businessType) {
        this.businessType = businessType;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getPayInterestWay() {
        return payInterestWay;
    }

    public void setPayInterestWay(int payInterestWay) {
        this.payInterestWay = payInterestWay;
    }

    public int getNextOrgType() {
        return nextOrgType;
    }

    public void setNextOrgType(int nextOrgType) {
        this.nextOrgType = nextOrgType;
    }

    public int getChannelType() {
        return channelType;
    }

    public void setChannelType(int channelType) {
        this.channelType = channelType;
    }
}
