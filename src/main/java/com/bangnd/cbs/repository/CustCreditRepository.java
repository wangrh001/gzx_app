package com.bangnd.cbs.repository;

import com.bangnd.cbs.entity.CustCredit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CustCreditRepository extends JpaRepository<CustCredit, Long> {
    public CustCredit findById(@Param(value="id") long id);
    public CustCredit findCustCreditByCustomerId(@Param(value="customerId") long id);
}
