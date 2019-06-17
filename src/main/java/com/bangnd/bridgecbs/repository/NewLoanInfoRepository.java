package com.bangnd.bridgecbs.repository;

import com.bangnd.bridgecbs.entity.NewLoanInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NewLoanInfoRepository extends JpaRepository<NewLoanInfo, Long> {

    @Query("select n from NewLoanInfo n where n.orderId = :orderId and n.state <> 100")
    public List<NewLoanInfo> findAllByOrderId(@Param(value = "orderId") Long orderId);


    @Query("select n from NewLoanInfo n where n.id = :id and n.state <>100")
    public NewLoanInfo findOneById(@Param(value = "id") Long id);
}
