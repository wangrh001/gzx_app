package com.bangnd.bridgecbs.service;

import com.bangnd.bridgecbs.entity.Mortgage;

import java.math.BigDecimal;
import java.util.List;

public interface MortgageService {
    public void save(Mortgage mortgage, Long orderId);

    public List<Mortgage> getAllByOrderId(Long orderId);

    public Mortgage getOneById(Long id);

    public void merge(Mortgage mortgage);

    public BigDecimal getTotalRegisterPrice(Long id);

    public BigDecimal getTotalEstimatePrice(Long id);
}
