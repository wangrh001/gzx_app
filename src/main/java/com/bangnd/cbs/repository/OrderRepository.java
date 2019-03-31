package com.bangnd.cbs.repository;

import com.bangnd.cbs.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor {
    //更新订单状态(只做逻辑删除)
    @Transactional
    @Modifying
    @Query("update Order o set o.state = 100 where o.id = :id")
    public void deleteById(@Param(value = "id") long id);

    //查询非作废的订单
    List<Order> findByOrderStateNot(@Param(value = "state") int state);

    public Order findById(@Param(value = "id") long id);

    @Query("select o from Order o where o.salerId=:salerId and o.signDate>=:startDate and o.signDate<=:endDate and o.state<>100")
    List<Order> findAllBySalsesId(@Param(value = "salerId") long salerId,
                                  @Param(value = "startDate") Date startDate,
                                  @Param(value = "endDate") Date date);
}
