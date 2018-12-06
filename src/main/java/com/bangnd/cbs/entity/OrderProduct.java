package com.bangnd.cbs.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

//订单产品表
@Entity
@Table(name="t_cbs_order_product")
public class OrderProduct {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private long orderId;

    @Column
    private long productId;

    //计划金额
    @Column
    private BigDecimal planAmount;

    //计划利率
    @Column
    private BigDecimal planInterest;

    //计划周期类型
    @Column
    private long planPeriodType;

    //计划周期数
    @Column
    private int planPeriodNum;

    //计划支付方式，1、等额本息；2、等额本金；3、月息年本
    @Column
    private long planPayWay;

    //批贷金额
    @Column
    private BigDecimal realAmount;

    //批贷利率
    @Column
    private BigDecimal realInterest;

    //真实周期类型
    @Column
    private long realPeriodType;

    //真实周期类型
    @Column
    private long realPeriodNum;

    //批贷支付方式，1、等额本息；2、等额本金；3、月息年本
    @Column
    private long realPayWay;

    //服务人员（内勤的产品对接岗、风控岗）
    @Column(nullable = false, unique = false)
    private long serviceId;

    //批贷时间，各产品的批贷时间可能不同
    @Column(nullable = true, unique = false)
    private Date approveTime;

    //1,已递交给银行；2、银行已批贷款；3、已放款
    //审批状态
    @Column
    private int approveState;

    //客户支付的服务费
    @Column
    private BigDecimal fee;

    //客户给服务费时间
    @Column(nullable = true, unique = false)
    private Date paymentTime;

    //抵押人和贷款人关系：
    //1、夫妻；2、直系亲属；3、同一人；4、旁系关系
    @Column
    private int relationship;

    //是否多个借款人（一般借款人年龄大需要子女共借）
    @Column(nullable = true, unique = false)
    private String isMutiLoaner;

    //方案来源：1、机器推荐；2、人工匹配
    @Column
    private int planSource;

    //订单产品状态：0/建议书阶段；1/客户同意；2/收集资料；3/审批通过；4/签订合同；5/支付完成；6/完结；7/取消
    @Column(nullable = false, unique = false)
    private int orderProdState;

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

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public BigDecimal getPlanAmount() {
        return planAmount;
    }

    public void setPlanAmount(BigDecimal planAmount) {
        this.planAmount = planAmount;
    }

    public BigDecimal getPlanInterest() {
        return planInterest;
    }

    public void setPlanInterest(BigDecimal planInterest) {
        this.planInterest = planInterest;
    }

    public long getPlanPeriodType() {
        return planPeriodType;
    }

    public void setPlanPeriodType(long planPeriodType) {
        this.planPeriodType = planPeriodType;
    }

    public int getPlanPeriodNum() {
        return planPeriodNum;
    }

    public void setPlanPeriodNum(int planPeriodNum) {
        this.planPeriodNum = planPeriodNum;
    }

    public BigDecimal getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(BigDecimal realAmount) {
        this.realAmount = realAmount;
    }

    public BigDecimal getRealInterest() {
        return realInterest;
    }

    public void setRealInterest(BigDecimal realInterest) {
        this.realInterest = realInterest;
    }

    public long getServiceId() {
        return serviceId;
    }

    public void setServiceId(long serviceId) {
        this.serviceId = serviceId;
    }

    public Date getApproveTime() {
        return approveTime;
    }

    public void setApproveTime(Date approveTime) {
        this.approveTime = approveTime;
    }

    public int getApproveState() {
        return approveState;
    }

    public void setApproveState(int approveState) {
        this.approveState = approveState;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public int getRelationship() {
        return relationship;
    }

    public void setRelationship(int relationship) {
        this.relationship = relationship;
    }

    public String getIsMutiLoaner() {
        return isMutiLoaner;
    }

    public void setIsMutiLoaner(String isMutiLoaner) {
        this.isMutiLoaner = isMutiLoaner;
    }

    public int getPlanSource() {
        return planSource;
    }

    public void setPlanSource(int planSource) {
        this.planSource = planSource;
    }

    public int getOrderProdState() {
        return orderProdState;
    }

    public void setOrderProdState(int orderProdState) {
        this.orderProdState = orderProdState;
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

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public long getPlanPayWay() {
        return planPayWay;
    }

    public void setPlanPayWay(long planPayWay) {
        this.planPayWay = planPayWay;
    }

    public long getRealPeriodType() {
        return realPeriodType;
    }

    public void setRealPeriodType(long realPeriodType) {
        this.realPeriodType = realPeriodType;
    }

    public long getRealPeriodNum() {
        return realPeriodNum;
    }

    public void setRealPeriodNum(long realPeriodNum) {
        this.realPeriodNum = realPeriodNum;
    }

    public long getRealPayWay() {
        return realPayWay;
    }

    public void setRealPayWay(long realPayWay) {
        this.realPayWay = realPayWay;
    }
}
