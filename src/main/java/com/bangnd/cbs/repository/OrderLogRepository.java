package com.bangnd.cbs.repository;

import com.bangnd.cbs.entity.OrderLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderLogRepository extends JpaRepository<OrderLog, Long> {
    public List<OrderLog> findAllByOrderId(@Param("orderId") long orderId);

    public Page<OrderLog> findAll(Specification specification, Pageable pageable);

    public List<OrderLog> findAllByOrderIdAndUserId(@Param("orderId") long orderId, @Param("userId") long userId);

    @Query("select o from OrderLog o where o.orderId=:orderId and o.formatInfoId=:formatInfoId")
    public OrderLog findByOrderIdAndFormatInfoId(@Param("orderId") long orderId,@Param("formatInfoId") long formatInfoId);
}
