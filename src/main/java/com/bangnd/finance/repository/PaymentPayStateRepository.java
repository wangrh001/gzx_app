package com.bangnd.finance.repository;

import com.bangnd.finance.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentPayStateRepository extends JpaRepository<PaymentPayState, Integer> {
}