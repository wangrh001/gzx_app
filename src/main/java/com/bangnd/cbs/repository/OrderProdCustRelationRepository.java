package com.bangnd.cbs.repository;

import com.bangnd.cbs.entity.OrderProdCustRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderProdCustRelationRepository extends JpaRepository<OrderProdCustRelation, Long> {
    public List<OrderProdCustRelation> findAllByOrderId(long orderId);

    @Query("select o from OrderProdCustRelation o where orderProductId = :orderProductId and identityType =:identityType")
    public OrderProdCustRelation findByOrderProductId(@Param(value = "orderProductId") long orderProductId,
                                                      @Param(value = "identityType") long identityType);

    public List<OrderProdCustRelation> findAllByOrderProductId(@Param(value = "orderProductId") long orderProductId);
}
