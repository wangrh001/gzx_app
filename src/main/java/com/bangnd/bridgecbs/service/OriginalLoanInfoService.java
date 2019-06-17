package com.bangnd.bridgecbs.service;

import com.bangnd.bridgecbs.entity.OriginalLoanInfo;

import java.math.BigDecimal;
import java.util.List;

public interface OriginalLoanInfoService {
    public List<OriginalLoanInfo> getAllByOrderId(Long orderId);

    public OriginalLoanInfo getOneById(Long id);

    public void save(OriginalLoanInfo originalLoanInfo,Long orderId);

    public void merge(OriginalLoanInfo originalLoanInfo);

    public BigDecimal getTotalLoanAmount(Long id);
    public BigDecimal getTotalCaptialInterest(Long id);
}
