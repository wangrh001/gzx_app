package com.bangnd.cbs.repository;

import com.bangnd.cbs.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    //更新订单状态(只做逻辑删除)
    @Modifying
    @Query("update Order o set o.orderState = 6 where o.id = :id")
    public void deleteByIds(@Param(value = "id") long id);
    //查询非作废的订单
    List<Order> findByOrderStateNot(@Param(value="status") int status);
}
