package com.bangnd.cbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
@Entity
public class TOrder {
    @Id
    @GeneratedValue
    private long id;
    //订单产品信息
    //产品id
    @Column(nullable = true, unique = false)
    private Integer productId;
    //产品类型  
    @Column(nullable = true, unique = false)
    private String productType;
    //贷款金额
    @Column(nullable = true, unique = false)
    private BigDecimal amount;
    //还款方式;1、等额本金；2、等额本息；3、月息年本
    @Column(nullable = true, unique = false)
    private String repayWay;
    //利息
    @Column(nullable = true, unique = false)
    private BigDecimal interest;

    //借款人id
    @Column(nullable = true, unique = false)
    private Integer loanerId;
    //抵押物id
    @Column(nullable = true, unique = false)
    private Integer mortgageObjId;
    //抵押人id
    @Column(nullable = true, unique = false)
    private Integer mortgagerId;

    //申请时间
    @Column(nullable = true, unique = false)
    private Date applyTime;
    //销售人员
    @Column(nullable = true, unique = false)
    private Integer agentId;
    //服务人员（内勤的产品对接岗、风控岗）
    @Column(nullable = true, unique = false)
    private Integer serviceId;
    //服务合同签订时间
    @Column(nullable = true, unique = false)
    private Date signTime;
    //批贷时间
    @Column(nullable = true, unique = false)
    private Date approveTime;
    //客户给服务费时间
    @Column(nullable = true, unique = false)
    private Date paymentTime;
    //支付服务费
    @Column(nullable = true, unique = false)
    private BigDecimal fee;

    @Column(nullable = true, unique = false)
    private Date createTime;
    @Column(nullable = true, unique = false)
    private Integer creator;
    @Column(nullable = true, unique = false)
    private Date updateTime;
    @Column(nullable = true, unique = false)
    private Integer updator;

    //订单状态
    @Column(nullable = true, unique = false)
    private String orderState;

    //是否多个借款人（一般借款人年龄大需要子女共借）
    @Column(nullable = true, unique = false)
    private String isMutiLoaner;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getRepayWay() {
        return repayWay;
    }

    public void setRepayWay(String repayWay) {
        this.repayWay = repayWay;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public Integer getLoanerId() {
        return loanerId;
    }

    public void setLoanerId(Integer loanerId) {
        this.loanerId = loanerId;
    }

    public Integer getMortgageObjId() {
        return mortgageObjId;
    }

    public void setMortgageObjId(Integer mortgageObjId) {
        this.mortgageObjId = mortgageObjId;
    }

    public Integer getMortgagerId() {
        return mortgagerId;
    }

    public void setMortgagerId(Integer mortgagerId) {
        this.mortgagerId = mortgagerId;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public Date getApproveTime() {
        return approveTime;
    }

    public void setApproveTime(Date approveTime) {
        this.approveTime = approveTime;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
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

    public String getIsMutiLoaner() {
        return isMutiLoaner;
    }

    public void setIsMutiLoaner(String isMutiLoaner) {
        this.isMutiLoaner = isMutiLoaner;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }
}
