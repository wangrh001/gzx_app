package com.bangnd.cbs.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

//客户公司表
@Entity
@Table(name = "t_cust_company")
public class CustCompany {
    @Id
    @GeneratedValue
    private long companyId;

    @Column
    private String companyName;

    //注册资金
    @Column
    private BigDecimal Capital;

    //注册日期
    @Column
    private Date registeredDate;

    //贷款人在该公司占股
    @Column
    private BigDecimal sharePercent;

    @Column
    private String licenceCode;

    @Column
    private String legalPerson;

    @Column
    private String phoneNo;

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public BigDecimal getCapital() {
        return Capital;
    }

    public void setCapital(BigDecimal capital) {
        Capital = capital;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public BigDecimal getSharePercent() {
        return sharePercent;
    }

    public void setSharePercent(BigDecimal sharePercent) {
        this.sharePercent = sharePercent;
    }

    public String getLicenceCode() {
        return licenceCode;
    }

    public void setLicenceCode(String licenceCode) {
        this.licenceCode = licenceCode;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
