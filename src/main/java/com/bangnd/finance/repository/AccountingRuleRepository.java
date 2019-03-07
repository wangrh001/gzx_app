package com.bangnd.finance.repository;

import com.bangnd.finance.entity.AccountingRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface AccountingRuleRepository extends JpaRepository<AccountingRule, Long>, JpaSpecificationExecutor {
    public AccountingRule findById(@Param(value = "id") long id);

    List<AccountingRule> findByStateNot(@Param(value = "status") int status);
}