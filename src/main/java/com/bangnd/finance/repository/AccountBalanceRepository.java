package com.bangnd.finance.repository;

import com.bangnd.finance.entity.AccountBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountBalanceRepository extends JpaRepository<AccountBalance, Integer> {
}