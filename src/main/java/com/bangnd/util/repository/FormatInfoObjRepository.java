package com.bangnd.util.repository;

import com.bangnd.util.entity.FormatInfoObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface FormatInfoObjRepository extends JpaRepository<FormatInfoObject, Long> {

    @Query("select f from FormatInfoObject  f where f.orderId=:orderId and state <> 100")
    public FormatInfoObject findByOrderId(@Param(value = "orderId") long orderId);

    @Modifying
    @Query("update FormatInfoObject set state = 100 where orderId = :orderId")
    public void updateStateByOrderId(@Param(value = "orderId") long orderId);

    @Query("select f.signDate from FormatInfoObject  f where f.orderId=:orderId")
    public Date getSignDate(@Param(value = "orderId") long orderId);
}
