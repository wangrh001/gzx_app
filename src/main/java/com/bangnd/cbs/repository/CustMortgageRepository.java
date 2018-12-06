package com.bangnd.cbs.repository;

import com.bangnd.cbs.entity.CustMortgage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CustMortgageRepository extends JpaRepository<CustMortgage, Long> {
    public CustMortgage findByMortgageId(@Param(value = "mortgageId") long id);
    public CustMortgage findMortgageByCustomerId(@Param(value = "customerId") long id);
}
