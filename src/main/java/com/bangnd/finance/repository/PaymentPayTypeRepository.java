package com.bangnd.finance.repository;

import com.bangnd.finance.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentPayTypeRepository extends JpaRepository<PaymentPayType, Integer> {


    @Query(value = "select p from PaymentPayType p where p.busiType=:busiType")
    public List<PaymentPayType> getNoBusiType(@Param("busiType") int busiType);
}