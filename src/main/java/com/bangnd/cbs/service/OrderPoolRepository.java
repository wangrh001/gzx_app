package com.bangnd.cbs.service;

import com.bangnd.cbs.entity.OrderPool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface OrderPoolRepository extends JpaRepository<OrderPool, Long> {

    @Query("select o from OrderPool o where orderId=:orderId and positionId = :positionId and state <> 100")
    public List<OrderPool> findAllByOrderIdAndPositionId(@Param(value = "orderId") long orderId,
                                                         @Param(value = "positionId") int positionId);

    @Query("select o from OrderPool o where orderId=:orderId and positionId = :positionId and doState=:doState and state <> 100")
    public OrderPool findOrderPoolByOrderIdAndPositionIdAndDoState(@Param(value = "orderId") long orderId,
                                                                   @Param(value = "positionId") int positionId,
                                                                   @Param(value = "doState") int doState);


    @Query("select o from OrderPool o where userId=:userId and doState = :doState and state <> 100")
    public List<OrderPool> findAllByUserId(@Param(value = "userId") long userId,
                                           @Param(value = "doState") int doState);

    @Query("select o from OrderPool o where userId=:userId and (doState = :doState1 or doState =:doState2) and state <> 100")
    public List<OrderPool> findAllByUserId(@Param(value = "userId") long userId,
                                           @Param(value = "doState1") int doState1,
                                           @Param(value = "doState2") int doState2);

    @Query("select max(o.intoPoolNo) from OrderPool o where userId=:userId and orderId=:orderId")
    public int getMaxNo(@Param(value = "userId") long userId, @Param(value = "orderId") long orderId);

    public OrderPool findOrderPoolByOrderIdAndDoState(@Param(value = "orderId") long orderId,
                                                      @Param(value = "doState") int doState);
    @Transactional
    @Modifying
    @Query("update OrderPool set userId = :userId where orderId=:orderId and doState = 2")
    public void updateDoingHandler(@Param(value = "userId") long userId,@Param(value = "orderId") long orderId);
}
