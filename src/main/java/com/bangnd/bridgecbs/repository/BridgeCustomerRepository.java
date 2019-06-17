package com.bangnd.bridgecbs.repository;

import com.bangnd.bridgecbs.entity.BridgeCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BridgeCustomerRepository extends JpaRepository<BridgeCustomer, Long> {

    @Query("select c from BridgeCustomer c where c.orderId=:orderId and c.state <> 100")
    public List<BridgeCustomer> findAllByOrderId(@Param(value = "orderId") Long orderId);

    @Query("select c from BridgeCustomer c where c.id=:id and c.state <> 100")
    public BridgeCustomer findOneById(@Param(value = "id") Long id);

    @Query("select c from BridgeCustomer c where c.mortgageId=:mortgageId and c.state <> 100")
    public List<BridgeCustomer> finAllByMortgageId(@Param(value = "mortgageId") Long mortgageId);

}
