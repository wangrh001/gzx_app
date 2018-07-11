package com.bangnd.cbs.repository;

import com.bangnd.cbs.entity.Mortgage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface MortgageRepository extends JpaRepository<Mortgage, Long> {
    public Mortgage findByMortgageId(@Param(value = "mortgageId") long id);
}
