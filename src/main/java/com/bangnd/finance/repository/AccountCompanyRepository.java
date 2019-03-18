package com.bangnd.finance.repository;

import com.bangnd.finance.entity.AccountCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountCompanyRepository extends JpaRepository<AccountCompany, Integer> {
}