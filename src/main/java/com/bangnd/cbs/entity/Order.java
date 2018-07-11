package com.bangnd.cbs.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
@Entity
@Table(name="T_CBS_ORDER")
public class Order {
    @Id
    @GeneratedValue
    private long orderId;

    @Column
    private long borrowerId;

    @Column
    private String borrowerName;

    //抵押人
    @Column
    private int mortgagorId;

    @Column
    private BigDecimal demandAmount;

    @Column
    private Date usingDate;

    @Column
    private Date endingDate;

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    //支付方式
    @Column
    private int payWay;

    @Column
    private long productType;

    //抵押物
    @Column
    private long mortgageId;


    @Column
    private int productId;

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
    //订单状态：0/建议书阶段；1/收集资料；2/审批通过；3/签订合同；4/支付完成；5/完结；6/订单取消
    @Column(nullable = false, unique = false)
    private int orderState;

    @Column(nullable = true, unique = false)
    private Date createTime;
    @Column(nullable = true, unique = false)
    private Integer creator;
    @Column(nullable = true, unique = false)
    private Date updateTime;
    @Column(nullable = true, unique = false)
    private Integer updator;

    //是否多个借款人（一般借款人年龄大需要子女共借）
    @Column(nullable = true, unique = false)
    private String isMutiLoaner;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(long borrowerId) {
        this.borrowerId = borrowerId;
    }

    public int getMortgagorId() {
        return mortgagorId;
    }

    public void setMortgagorId(int mortgagorId) {
        this.mortgagorId = mortgagorId;
    }

    public BigDecimal getDemandAmount() {
        return demandAmount;
    }

    public void setDemandAmount(BigDecimal demandAmount) {
        this.demandAmount = demandAmount;
    }

    public Date getUsingDate() {
        return usingDate;
    }

    public void setUsingDate(Date usingDate) {
        this.usingDate = usingDate;
    }

    public int getPayWay() {
        return payWay;
    }

    public void setPayWay(int payWay) {
        this.payWay = payWay;
    }

    public long getProductType(){
        return productType;
    }

    public void setProductType(long productType) {
        this.productType = productType;
    }

    public long getMortgageId() {
        return mortgageId;
    }

    public void setMortgageId(long mortgageId) {
        this.mortgageId = mortgageId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public String getIsMutiLoaner() {
        return isMutiLoaner;
    }

    public void setIsMutiLoaner(String isMutiLoaner) {
        this.isMutiLoaner = isMutiLoaner;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }
}
