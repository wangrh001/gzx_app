package com.bangnd.finance.repository;

import com.bangnd.finance.entity.AccountBank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountBankRepository extends JpaRepository<AccountBank, Integer> {
}