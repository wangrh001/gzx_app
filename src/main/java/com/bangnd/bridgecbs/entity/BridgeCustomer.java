package com.bangnd.bridgecbs.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_bridge_customer")
public class BridgeCustomer {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private long orderId;
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private Date birthday;

    //1、身份证；2、回乡证（仅港澳）；3、营业执照
    @Column
    private int certiType;
    @Column
    private String certiTypeName;

    @Column
    private String certiCode;
    @Column
    private String address;
    @Column
    private String phone;
    @Column
    private int gender;
    @Column
    private String job;
    @Column
    private long custState;
    //是不是新加入股东;Y、是；N、否
    @Column
    private String isNewStockholder;
    @Column
    private String bankCode;
    @Column
    private int bankId;

    //1、卖方；2、新贷款共借人；3、共借人；4、担保方；5、承保方；6、买方
    @Column
    private int custType;

    @Column
    private String custTypeName;

    //如果是产权人，需要知道，这个产权人对产权的占比
    @Column
    private int percent;
    //如果是产权人，需要关联产权ID；
    @Column
    private long mortgageId;

    //成为新股东月数
    @Column
    private int beStockholderMonths;

    @Column
    private String companyName;

    @Column
    private String licenseCode;

    @Column
    private String lowPerson;

    @Column
    private String companyPhone;


    @Column
    private int state;

    @Column(nullable = true, unique = false)
    private Date createTime;
    @Column(nullable = true, unique = false)
    private Integer creator;
    @Column(nullable = true, unique = false)
    private Date updateTime;
    @Column(nullable = true, unique = false)
    private Integer updator;

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

    public String getCertiCode() {
        return certiCode;
    }

    public void setCertiCode(String certiCode) {
        this.certiCode = certiCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCustState() {
        return custState;
    }

    public void setCustState(long custState) {
        this.custState = custState;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getIsNewStockholder() {
        return isNewStockholder;
    }

    public void setIsNewStockholder(String isNewStockholder) {
        this.isNewStockholder = isNewStockholder;
    }

    public int getBeStockholderMonths() {
        return beStockholderMonths;
    }

    public void setBeStockholderMonths(int beStockholderMonths) {
        this.beStockholderMonths = beStockholderMonths;
    }

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

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public int getCertiType() {
        return certiType;
    }

    public void setCertiType(int certiType) {
        this.certiType = certiType;
    }

    public int getCustType() {
        return custType;
    }

    public void setCustType(int custType) {
        this.custType = custType;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public long getMortgageId() {
        return mortgageId;
    }

    public void setMortgageId(long mortgageId) {
        this.mortgageId = mortgageId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getCertiTypeName() {
        return certiTypeName;
    }

    public void setCertiTypeName(String certiTypeName) {
        this.certiTypeName = certiTypeName;
    }

    public String getCustTypeName() {
        return custTypeName;
    }

    public void setCustTypeName(String custTypeName) {
        this.custTypeName = custTypeName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLicenseCode() {
        return licenseCode;
    }

    public void setLicenseCode(String licenseCode) {
        this.licenseCode = licenseCode;
    }

    public String getLowPerson() {
        return lowPerson;
    }

    public void setLowPerson(String lowPerson) {
        this.lowPerson = lowPerson;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }
}