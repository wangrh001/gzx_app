package com.bangnd.util.repository;

import com.bangnd.util.entity.OrderState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderStateRepository extends JpaRepository<OrderState, Long> {

    @Query("select o from OrderState o where o.busiType=:busiType")
    public List<OrderState> findAllByBusiType(@Param(value = "busiType") int busiType);
}
