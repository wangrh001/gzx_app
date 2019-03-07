package com.bangnd.cbs.repository;

import com.bangnd.cbs.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Integer> {
}
