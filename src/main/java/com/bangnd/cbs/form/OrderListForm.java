package com.bangnd.cbs.form;

import java.math.BigDecimal;
import java.util.Date;

public class OrderListForm {
    private long orderId;
    private String applicantName;
    private BigDecimal amount;
    private Date demandDate;
    private String orderState;
    private String nextHandler;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDemandDate() {
        return demandDate;
    }

    public void setDemandDate(Date demandDate) {
        this.demandDate = demandDate;
    }

    public String getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(String nextHandler) {
        this.nextHandler = nextHandler;
    }
}
