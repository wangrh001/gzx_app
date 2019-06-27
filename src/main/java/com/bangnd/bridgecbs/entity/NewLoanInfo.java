package com.bangnd.bridgecbs.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "t_bridge_new_loan_info")
public class NewLoanInfo {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private long orderId;

    @Column
    private long orderProductId;

    @Column
    private int organCode;

    @Column
    private int organType;

    @Column
    private String organTypeName;

    @Column
    private int ifOtherPart;

    @Column
    private BigDecimal approveAmount;

    @Column
    private int loanType;

    @Column
    private int loanCondition;

    @Column
    private String loanConditionName;

    @Column
    private String passCardAccountName;
    @Column
    private int passCardBankId;
    @Column
    private String passCardBankIdName;
    @Column
    private String passCardAccountCode;
    @Column
    private String passCardAccountCertiCode;
    @Column
    private BigDecimal passCardAmount;

    @Column
    private String contactName;

    @Column
    private String contactPhone;

    @Column
    private int state;
    @Column
    private long creator;
    @Column
    private Date createTime;
    @Column
    private long updator;
    @Column
    private Date updateTime;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public long getCreator() {
        return creator;
    }

    public void setCreator(long creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public long getUpdator() {
        return updator;
    }

    public void setUpdator(long updator) {
        this.updator = updator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getOrganCode() {
        return organCode;
    }

    public void setOrganCode(int organCode) {
        this.organCode = organCode;
    }

    public int getOrganType() {
        return organType;
    }

    public void setOrganType(int organType) {
        this.organType = organType;
    }

    public int getIfOtherPart() {
        return ifOtherPart;
    }

    public void setIfOtherPart(int ifOtherPart) {
        this.ifOtherPart = ifOtherPart;
    }

    public BigDecimal getApproveAmount() {
        return approveAmount;
    }

    public void setApproveAmount(BigDecimal approveAmount) {
        this.approveAmount = approveAmount;
    }

    public int getLoanType() {
        return loanType;
    }

    public void setLoanType(int loanType) {
        this.loanType = loanType;
    }

    public int getLoanCondition() {
        return loanCondition;
    }

    public void setLoanCondition(int loanCondition) {
        this.loanCondition = loanCondition;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
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

    public String getOrganTypeName() {
        return organTypeName;
    }

    public void setOrganTypeName(String organTypeName) {
        this.organTypeName = organTypeName;
    }

    public String getLoanConditionName() {
        return loanConditionName;
    }

    public void setLoanConditionName(String loanConditionName) {
        this.loanConditionName = loanConditionName;
    }

    public String getPassCardAccountName() {
        return passCardAccountName;
    }

    public void setPassCardAccountName(String passCardAccountName) {
        this.passCardAccountName = passCardAccountName;
    }

    public int getPassCardBankId() {
        return passCardBankId;
    }

    public void setPassCardBankId(int passCardBankId) {
        this.passCardBankId = passCardBankId;
    }

    public String getPassCardAccountCode() {
        return passCardAccountCode;
    }

    public void setPassCardAccountCode(String passCardAccountCode) {
        this.passCardAccountCode = passCardAccountCode;
    }

    public String getPassCardAccountCertiCode() {
        return passCardAccountCertiCode;
    }

    public void setPassCardAccountCertiCode(String passCardAccountCertiCode) {
        this.passCardAccountCertiCode = passCardAccountCertiCode;
    }

    public BigDecimal getPassCardAmount() {
        return passCardAmount;
    }

    public void setPassCardAmount(BigDecimal passCardAmount) {
        this.passCardAmount = passCardAmount;
    }

    public String getPassCardBankIdName() {
        return passCardBankIdName;
    }

    public void setPassCardBankIdName(String passCardBankIdName) {
        this.passCardBankIdName = passCardBankIdName;
    }
}
