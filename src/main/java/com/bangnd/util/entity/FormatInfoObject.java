package com.bangnd.util.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "t_format_info_obj")
public class FormatInfoObject {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private long orderId;
    @Column
    private BigDecimal amount;
    @Column
    private BigDecimal organAmount;
    @Column
    private BigDecimal selfAmount;
    @Column
    private BigDecimal chainFamilyFastOutPrice;
    @Column
    private BigDecimal extensionFee;
    @Column
    private BigDecimal houseEvaluatePrice;
    @Column
    private BigDecimal houseSquare;
    @Column
    private Integer houseArea;
    @Column
    private Integer mortgageNum;
    @Column
    private BigDecimal nextAount;
    @Column
    private BigDecimal upPenaltyInterest;
    @Column
    private BigDecimal upResidueCapital;
    @Column
    private BigDecimal upResidueInterest;
    @Column
    private Date accountProvisionDate;
    @Column
    private Date approvedDate;
    @Column
    private Date assessmentDate;
    @Column
    private Date bigDataDate;
    @Column
    private Date chainFamilyEvaluationDate;
    @Column
    private Date checkExpirationDate;
    @Column
    private Date deductionDate;
    @Column
    private Date depositCertificatesDate;
    @Column
    private Date feeDate;
    @Column
    private Date fileCollectionDate;
    @Column
    private Date fileReportDate;
    @Column
    private Date finishDate;
    @Column
    private String houseAddress;
    @Column
    private Date houseOwnershipExpectedReceiveDate;
    @Column
    private Date houseOwnershipRealReceiveDate;
    @Column
    private Date loanDate;
    @Column
    private Date nextExceptionLoanDate;
    @Column
    private Date nextHouseOtherReceiveDate;
    @Column
    private Date nextHouseOwnershipDepositDate;
    @Column
    private Date nextHouseOwnershipSendDate;
    @Column
    private Date nextInterestPaymentDate;
    @Column
    private Date nextRealLoanDate;
    @Column
    private Date nextVerificationDate;
    @Column
    private Date payInterestAlertDate;
    @Column
    private Date reContractDate;
    @Column
    private Date reminderDate;
    @Column
    private Date reservedRepaymentDate;
    @Column
    private String titleCertificateNO;
    @Column
    private Date unzipDocExpectedReceiveDate;
    @Column
    private Date unzipDocRealReceiveDate;
    @Column
    private Date unzipDocUndepositDate;
    @Column
    private Date upUnzipDoc;
    @Column
    private Date verificationApprovalDate;
    @Column
    private Date verificationDate;
    @Column
    private Date verificationNotarizationDate;

    @Column
    private Date signDate;

    @Column
    private String bigDateConclusion;
    @Column
    private String certiNO;
    @Column
    private String customerCapitalAccountNO;
    @Column
    private String customerCapitalAccountName;
    @Column
    private String customerCapitalBank;
    @Column
    private String nextCapitalAccountName;
    @Column
    private String nextCapitalAccountProvider;
    @Column
    private String nextCapitalBank;
    @Column
    private String nextName;
    @Column
    private Integer nextOrganType;
    @Column
    private String propertyOwner;
    @Column
    private String spouseCertiNO;
    @Column
    private String spouseName;
    @Column
    private String upCapitalAccountNO;
    @Column
    private String upCapitalAccountName;
    @Column
    private String upCapitalBank;
    @Column
    private String upName;
    @Column
    private Integer applyDays;
    @Column
    private Integer customerFirstPayDays;
    @Column
    private Integer exceptionDays;
    @Column
    private Integer firstExtensionDays;
    @Column
    private Integer houseType;
    @Column
    private Integer ifExtension;
    @Column
    private Integer maritalStatus;
    @Column
    private Integer nextIfLimitPurpose;
    @Column
    private Integer nextIfNotarization;
    @Column
    private Integer nextLoanWay;
    @Column
    private Integer overdueDays;
    @Column
    private Integer tellUpDays;
    @Column
    private Integer upIfHouseDeposit;
    @Column
    private Integer upIfOverdue;
    @Column
    private Integer upOverdueDays;
    @Column(nullable = true, unique = false)
    private Date createTime;
    @Column(nullable = true, unique = false)
    private int creator;
    @Column(nullable = true, unique = false)
    private Date updateTime;
    @Column(nullable = true, unique = false)
    private int updator;
    @Column
    private BigDecimal coveredArea;
    @Column
    private Date certiEndDate;
    @Column
    private Date certiStartDate;
    @Column
    private String belongType;
    @Column
    private String certiAddress;
    @Column
    private String certiIssue;
    @Column
    private String houseCertiNo;
    @Column
    private String houseGetWay;
    @Column
    private String houseOwnership;
    @Column
    private String housePurpose;
    @Column
    private String houseRigthType;
    @Column
    private String houseUnitNo;
    @Column
    private String landGetWay;
    @Column
    private String landPurpose;
    @Column
    private String landRightType;
    @Column
    private String nationality;
    @Column
    private String serviceLife;
    @Column
    private String applyTel;

    public BigDecimal getCoveredArea() {
        return coveredArea;
    }

    public void setCoveredArea(BigDecimal coveredArea) {
        this.coveredArea = coveredArea;
    }

    public Date getCertiEndDate() {
        return certiEndDate;
    }

    public void setCertiEndDate(Date certiEndDate) {
        this.certiEndDate = certiEndDate;
    }

    public Date getCertiStartDate() {
        return certiStartDate;
    }

    public void setCertiStartDate(Date certiStartDate) {
        this.certiStartDate = certiStartDate;
    }

    public String getBelongType() {
        return belongType;
    }

    public void setBelongType(String belongType) {
        this.belongType = belongType;
    }

    public String getCertiAddress() {
        return certiAddress;
    }

    public void setCertiAddress(String certiAddress) {
        this.certiAddress = certiAddress;
    }

    public String getCertiIssue() {
        return certiIssue;
    }

    public void setCertiIssue(String certiIssue) {
        this.certiIssue = certiIssue;
    }

    public String getHouseCertiNo() {
        return houseCertiNo;
    }

    public void setHouseCertiNo(String houseCertiNo) {
        this.houseCertiNo = houseCertiNo;
    }

    public String getHouseGetWay() {
        return houseGetWay;
    }

    public void setHouseGetWay(String houseGetWay) {
        this.houseGetWay = houseGetWay;
    }

    public String getHouseOwnership() {
        return houseOwnership;
    }

    public void setHouseOwnership(String houseOwnership) {
        this.houseOwnership = houseOwnership;
    }

    public String getHousePurpose() {
        return housePurpose;
    }

    public void setHousePurpose(String housePurpose) {
        this.housePurpose = housePurpose;
    }

    public String getHouseRigthType() {
        return houseRigthType;
    }

    public void setHouseRigthType(String houseRigthType) {
        this.houseRigthType = houseRigthType;
    }

    public String getHouseUnitNo() {
        return houseUnitNo;
    }

    public void setHouseUnitNo(String houseUnitNo) {
        this.houseUnitNo = houseUnitNo;
    }

    public String getLandGetWay() {
        return landGetWay;
    }

    public void setLandGetWay(String landGetWay) {
        this.landGetWay = landGetWay;
    }

    public String getLandPurpose() {
        return landPurpose;
    }

    public void setLandPurpose(String landPurpose) {
        this.landPurpose = landPurpose;
    }

    public String getLandRightType() {
        return landRightType;
    }

    public void setLandRightType(String landRightType) {
        this.landRightType = landRightType;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getServiceLife() {
        return serviceLife;
    }

    public void setServiceLife(String serviceLife) {
        this.serviceLife = serviceLife;
    }

    @Column
    private Integer state;


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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getChainFamilyFastOutPrice() {
        return chainFamilyFastOutPrice;
    }

    public void setChainFamilyFastOutPrice(BigDecimal chainFamilyFastOutPrice) {
        this.chainFamilyFastOutPrice = chainFamilyFastOutPrice;
    }

    public BigDecimal getExtensionFee() {
        return extensionFee;
    }

    public void setExtensionFee(BigDecimal extensionFee) {
        this.extensionFee = extensionFee;
    }

    public BigDecimal getHouseEvaluatePrice() {
        return houseEvaluatePrice;
    }

    public void setHouseEvaluatePrice(BigDecimal houseEvaluatePrice) {
        this.houseEvaluatePrice = houseEvaluatePrice;
    }

    public BigDecimal getHouseSquare() {
        return houseSquare;
    }

    public void setHouseSquare(BigDecimal houseSquare) {
        this.houseSquare = houseSquare;
    }

    public BigDecimal getNextAount() {
        return nextAount;
    }

    public void setNextAount(BigDecimal nextAount) {
        this.nextAount = nextAount;
    }

    public BigDecimal getUpPenaltyInterest() {
        return upPenaltyInterest;
    }

    public void setUpPenaltyInterest(BigDecimal upPenaltyInterest) {
        this.upPenaltyInterest = upPenaltyInterest;
    }

    public BigDecimal getUpResidueCapital() {
        return upResidueCapital;
    }

    public void setUpResidueCapital(BigDecimal upResidueCapital) {
        this.upResidueCapital = upResidueCapital;
    }

    public BigDecimal getUpResidueInterest() {
        return upResidueInterest;
    }

    public void setUpResidueInterest(BigDecimal upResidueInterest) {
        this.upResidueInterest = upResidueInterest;
    }

    public Date getAccountProvisionDate() {
        return accountProvisionDate;
    }

    public void setAccountProvisionDate(Date accountProvisionDate) {
        this.accountProvisionDate = accountProvisionDate;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public Date getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(Date assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    public Date getBigDataDate() {
        return bigDataDate;
    }

    public void setBigDataDate(Date bigDataDate) {
        this.bigDataDate = bigDataDate;
    }

    public Date getChainFamilyEvaluationDate() {
        return chainFamilyEvaluationDate;
    }

    public void setChainFamilyEvaluationDate(Date chainFamilyEvaluationDate) {
        this.chainFamilyEvaluationDate = chainFamilyEvaluationDate;
    }

    public Date getCheckExpirationDate() {
        return checkExpirationDate;
    }

    public void setCheckExpirationDate(Date checkExpirationDate) {
        this.checkExpirationDate = checkExpirationDate;
    }

    public Date getDeductionDate() {
        return deductionDate;
    }

    public void setDeductionDate(Date deductionDate) {
        this.deductionDate = deductionDate;
    }

    public Date getDepositCertificatesDate() {
        return depositCertificatesDate;
    }

    public void setDepositCertificatesDate(Date depositCertificatesDate) {
        this.depositCertificatesDate = depositCertificatesDate;
    }

    public Date getFeeDate() {
        return feeDate;
    }

    public void setFeeDate(Date feeDate) {
        this.feeDate = feeDate;
    }

    public Date getFileCollectionDate() {
        return fileCollectionDate;
    }

    public void setFileCollectionDate(Date fileCollectionDate) {
        this.fileCollectionDate = fileCollectionDate;
    }

    public Date getFileReportDate() {
        return fileReportDate;
    }

    public void setFileReportDate(Date fileReportDate) {
        this.fileReportDate = fileReportDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public Date getHouseOwnershipExpectedReceiveDate() {
        return houseOwnershipExpectedReceiveDate;
    }

    public void setHouseOwnershipExpectedReceiveDate(Date houseOwnershipExpectedReceiveDate) {
        this.houseOwnershipExpectedReceiveDate = houseOwnershipExpectedReceiveDate;
    }

    public Date getHouseOwnershipRealReceiveDate() {
        return houseOwnershipRealReceiveDate;
    }

    public void setHouseOwnershipRealReceiveDate(Date houseOwnershipRealReceiveDate) {
        this.houseOwnershipRealReceiveDate = houseOwnershipRealReceiveDate;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getNextExceptionLoanDate() {
        return nextExceptionLoanDate;
    }

    public void setNextExceptionLoanDate(Date nextExceptionLoanDate) {
        this.nextExceptionLoanDate = nextExceptionLoanDate;
    }

    public Date getNextHouseOtherReceiveDate() {
        return nextHouseOtherReceiveDate;
    }

    public void setNextHouseOtherReceiveDate(Date nextHouseOtherReceiveDate) {
        this.nextHouseOtherReceiveDate = nextHouseOtherReceiveDate;
    }

    public Date getNextHouseOwnershipDepositDate() {
        return nextHouseOwnershipDepositDate;
    }

    public void setNextHouseOwnershipDepositDate(Date nextHouseOwnershipDepositDate) {
        this.nextHouseOwnershipDepositDate = nextHouseOwnershipDepositDate;
    }

    public Date getNextHouseOwnershipSendDate() {
        return nextHouseOwnershipSendDate;
    }

    public void setNextHouseOwnershipSendDate(Date nextHouseOwnershipSendDate) {
        this.nextHouseOwnershipSendDate = nextHouseOwnershipSendDate;
    }

    public Date getNextInterestPaymentDate() {
        return nextInterestPaymentDate;
    }

    public void setNextInterestPaymentDate(Date nextInterestPaymentDate) {
        this.nextInterestPaymentDate = nextInterestPaymentDate;
    }

    public Date getNextRealLoanDate() {
        return nextRealLoanDate;
    }

    public void setNextRealLoanDate(Date nextRealLoanDate) {
        this.nextRealLoanDate = nextRealLoanDate;
    }

    public Date getNextVerificationDate() {
        return nextVerificationDate;
    }

    public void setNextVerificationDate(Date nextVerificationDate) {
        this.nextVerificationDate = nextVerificationDate;
    }

    public Date getPayInterestAlertDate() {
        return payInterestAlertDate;
    }

    public void setPayInterestAlertDate(Date payInterestAlertDate) {
        this.payInterestAlertDate = payInterestAlertDate;
    }

    public Date getReContractDate() {
        return reContractDate;
    }

    public void setReContractDate(Date reContractDate) {
        this.reContractDate = reContractDate;
    }

    public Date getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(Date reminderDate) {
        this.reminderDate = reminderDate;
    }

    public Date getReservedRepaymentDate() {
        return reservedRepaymentDate;
    }

    public void setReservedRepaymentDate(Date reservedRepaymentDate) {
        this.reservedRepaymentDate = reservedRepaymentDate;
    }

    public Date getUnzipDocExpectedReceiveDate() {
        return unzipDocExpectedReceiveDate;
    }

    public void setUnzipDocExpectedReceiveDate(Date unzipDocExpectedReceiveDate) {
        this.unzipDocExpectedReceiveDate = unzipDocExpectedReceiveDate;
    }

    public Date getUnzipDocRealReceiveDate() {
        return unzipDocRealReceiveDate;
    }

    public void setUnzipDocRealReceiveDate(Date unzipDocRealReceiveDate) {
        this.unzipDocRealReceiveDate = unzipDocRealReceiveDate;
    }

    public Date getUnzipDocUndepositDate() {
        return unzipDocUndepositDate;
    }

    public void setUnzipDocUndepositDate(Date unzipDocUndepositDate) {
        this.unzipDocUndepositDate = unzipDocUndepositDate;
    }

    public Date getUpUnzipDoc() {
        return upUnzipDoc;
    }

    public void setUpUnzipDoc(Date upUnzipDoc) {
        this.upUnzipDoc = upUnzipDoc;
    }

    public Date getVerificationApprovalDate() {
        return verificationApprovalDate;
    }

    public void setVerificationApprovalDate(Date verificationApprovalDate) {
        this.verificationApprovalDate = verificationApprovalDate;
    }

    public Date getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(Date verificationDate) {
        this.verificationDate = verificationDate;
    }

    public Date getVerificationNotarizationDate() {
        return verificationNotarizationDate;
    }

    public void setVerificationNotarizationDate(Date verificationNotarizationDate) {
        this.verificationNotarizationDate = verificationNotarizationDate;
    }

    public String getBigDateConclusion() {
        return bigDateConclusion;
    }

    public void setBigDateConclusion(String bigDateConclusion) {
        this.bigDateConclusion = bigDateConclusion;
    }

    public String getCertiNO() {
        return certiNO;
    }

    public void setCertiNO(String certiNO) {
        this.certiNO = certiNO;
    }

    public String getCustomerCapitalAccountNO() {
        return customerCapitalAccountNO;
    }

    public void setCustomerCapitalAccountNO(String customerCapitalAccountNO) {
        this.customerCapitalAccountNO = customerCapitalAccountNO;
    }

    public String getCustomerCapitalAccountName() {
        return customerCapitalAccountName;
    }

    public void setCustomerCapitalAccountName(String customerCapitalAccountName) {
        this.customerCapitalAccountName = customerCapitalAccountName;
    }

    public String getCustomerCapitalBank() {
        return customerCapitalBank;
    }

    public void setCustomerCapitalBank(String customerCapitalBank) {
        this.customerCapitalBank = customerCapitalBank;
    }

    public String getNextCapitalAccountName() {
        return nextCapitalAccountName;
    }

    public void setNextCapitalAccountName(String nextCapitalAccountName) {
        this.nextCapitalAccountName = nextCapitalAccountName;
    }

    public String getNextCapitalAccountProvider() {
        return nextCapitalAccountProvider;
    }

    public void setNextCapitalAccountProvider(String nextCapitalAccountProvider) {
        this.nextCapitalAccountProvider = nextCapitalAccountProvider;
    }

    public String getNextCapitalBank() {
        return nextCapitalBank;
    }

    public void setNextCapitalBank(String nextCapitalBank) {
        this.nextCapitalBank = nextCapitalBank;
    }

    public String getNextName() {
        return nextName;
    }

    public void setNextName(String nextName) {
        this.nextName = nextName;
    }

    public String getPropertyOwner() {
        return propertyOwner;
    }

    public void setPropertyOwner(String propertyOwner) {
        this.propertyOwner = propertyOwner;
    }

    public String getSpouseCertiNO() {
        return spouseCertiNO;
    }

    public void setSpouseCertiNO(String spouseCertiNO) {
        this.spouseCertiNO = spouseCertiNO;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getUpCapitalAccountNO() {
        return upCapitalAccountNO;
    }

    public void setUpCapitalAccountNO(String upCapitalAccountNO) {
        this.upCapitalAccountNO = upCapitalAccountNO;
    }

    public String getUpCapitalAccountName() {
        return upCapitalAccountName;
    }

    public void setUpCapitalAccountName(String upCapitalAccountName) {
        this.upCapitalAccountName = upCapitalAccountName;
    }

    public String getUpCapitalBank() {
        return upCapitalBank;
    }

    public void setUpCapitalBank(String upCapitalBank) {
        this.upCapitalBank = upCapitalBank;
    }

    public String getUpName() {
        return upName;
    }

    public void setUpName(String upName) {
        this.upName = upName;
    }

    public Integer getApplyDays() {
        return applyDays;
    }

    public void setApplyDays(Integer applyDays) {
        this.applyDays = applyDays;
    }

    public Integer getCustomerFirstPayDays() {
        return customerFirstPayDays;
    }

    public void setCustomerFirstPayDays(Integer customerFirstPayDays) {
        this.customerFirstPayDays = customerFirstPayDays;
    }

    public Integer getExceptionDays() {
        return exceptionDays;
    }

    public void setExceptionDays(Integer exceptionDays) {
        this.exceptionDays = exceptionDays;
    }

    public Integer getFirstExtensionDays() {
        return firstExtensionDays;
    }

    public void setFirstExtensionDays(Integer firstExtensionDays) {
        this.firstExtensionDays = firstExtensionDays;
    }

    public Integer getHouseType() {
        return houseType;
    }

    public void setHouseType(Integer houseType) {
        this.houseType = houseType;
    }

    public Integer getIfExtension() {
        return ifExtension;
    }

    public void setIfExtension(Integer ifExtension) {
        this.ifExtension = ifExtension;
    }

    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Integer getNextIfLimitPurpose() {
        return nextIfLimitPurpose;
    }

    public void setNextIfLimitPurpose(Integer nextIfLimitPurpose) {
        this.nextIfLimitPurpose = nextIfLimitPurpose;
    }

    public Integer getNextIfNotarization() {
        return nextIfNotarization;
    }

    public void setNextIfNotarization(Integer nextIfNotarization) {
        this.nextIfNotarization = nextIfNotarization;
    }

    public Integer getNextLoanWay() {
        return nextLoanWay;
    }

    public void setNextLoanWay(Integer nextLoanWay) {
        this.nextLoanWay = nextLoanWay;
    }

    public Integer getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(Integer overdueDays) {
        this.overdueDays = overdueDays;
    }

    public Integer getTellUpDays() {
        return tellUpDays;
    }

    public void setTellUpDays(Integer tellUpDays) {
        this.tellUpDays = tellUpDays;
    }

    public Integer getUpIfHouseDeposit() {
        return upIfHouseDeposit;
    }

    public void setUpIfHouseDeposit(Integer upIfHouseDeposit) {
        this.upIfHouseDeposit = upIfHouseDeposit;
    }

    public Integer getUpIfOverdue() {
        return upIfOverdue;
    }

    public void setUpIfOverdue(Integer upIfOverdue) {
        this.upIfOverdue = upIfOverdue;
    }

    public Integer getUpOverdueDays() {
        return upOverdueDays;
    }

    public void setUpOverdueDays(Integer upOverdueDays) {
        this.upOverdueDays = upOverdueDays;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getTitleCertificateNO() {
        return titleCertificateNO;
    }

    public void setTitleCertificateNO(String titleCertificateNO) {
        this.titleCertificateNO = titleCertificateNO;
    }

    public Integer getNextOrganType() {
        return nextOrganType;
    }

    public void setNextOrganType(Integer nextOrganType) {
        this.nextOrganType = nextOrganType;
    }

    public String getApplyTel() {
        return applyTel;
    }

    public void setApplyTel(String applyTel) {
        this.applyTel = applyTel;
    }

    public Integer getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(Integer houseArea) {
        this.houseArea = houseArea;
    }

    public Integer getMortgageNum() {
        return mortgageNum;
    }

    public void setMortgageNum(Integer mortgageNum) {
        this.mortgageNum = mortgageNum;
    }

    public BigDecimal getOrganAmount() {
        return organAmount;
    }

    public void setOrganAmount(BigDecimal organAmount) {
        this.organAmount = organAmount;
    }

    public BigDecimal getSelfAmount() {
        return selfAmount;
    }

    public void setSelfAmount(BigDecimal selfAmount) {
        this.selfAmount = selfAmount;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }


}
