package com.bangnd.bridgecbs.repository;

import com.bangnd.bridgecbs.entity.OriginalLoanInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OriginalLoanInfoRepository extends JpaRepository<OriginalLoanInfo, Long> {

    @Query("select o from OriginalLoanInfo  o where o.orderId=:orderId and o.state <> 100")
    public List<OriginalLoanInfo> findAllByOrderId(@Param(value = "orderId") Long orderId);

    @Query("select o from OriginalLoanInfo  o where o.id=:id and o.state <> 100")
    public OriginalLoanInfo findOneById(@Param(value = "id") Long id);

}
