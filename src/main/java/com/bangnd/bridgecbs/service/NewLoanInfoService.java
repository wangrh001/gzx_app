package com.bangnd.bridgecbs.service;

import com.bangnd.bridgecbs.entity.NewLoanInfo;

import java.math.BigDecimal;
import java.util.List;

public interface NewLoanInfoService {
    public List<NewLoanInfo> getAllByOrderId(Long orderId);

    public NewLoanInfo getOneById(Long id);

    public void save(NewLoanInfo newLoanInfo, Long orderId);

    public void merge(NewLoanInfo newLoanInfo);

    public BigDecimal getTotalApproveAmount(Long id);
}
