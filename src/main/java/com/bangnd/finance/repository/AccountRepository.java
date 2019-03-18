package com.bangnd.finance.repository;

import com.bangnd.finance.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long>, JpaSpecificationExecutor {
    public Account findById(@Param(value = "id") long id);

    List<Account> findByStateNot(@Param(value = "status") int status);
}