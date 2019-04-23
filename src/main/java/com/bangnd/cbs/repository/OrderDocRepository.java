package com.bangnd.cbs.repository;

import com.bangnd.cbs.entity.OrderDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDocRepository extends JpaRepository<OrderDocument, Long> {

    @Query("select o from OrderDocument o where o.orderId=:orderId and o.state =1")
    public List<OrderDocument> findAllByOrderId(@Param(value = "orderId") Long orderId);

    @Query("select o from OrderDocument o where o.orderId=:orderId and o.docType = :docType and o.state =1")
    public List<OrderDocument> findAllByOrderIdAndType(@Param(value = "orderId") Long orderId,
                                                       @Param(value = "docType") int docType);
}
