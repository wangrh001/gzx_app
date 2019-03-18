package com.bangnd.cbs.repository;

import com.bangnd.cbs.entity.ProdInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdInterestRepository extends JpaRepository<ProdInterest, Long>, JpaSpecificationExecutor {
    public ProdInterest findById(@Param(value = "id") long id);

    List<ProdInterest> findByStateNot(@Param(value = "status") int status);
}