package com.bangnd.cbs.repository;

import com.bangnd.cbs.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
    //public List<OrderProduct> getOrderProductList(@Param(value="orderId") long id);

    @Query("select o from OrderProduct o where orderId = :orderId and o.state<>:state")
    public List<OrderProduct> findByOrderId(@Param(value = "orderId") long id,
                                            @Param(value = "state") int state);

    public OrderProduct findById(@Param(value = "id") long id);

    //获取抵押贷款的订单、状态为已经签约成功
    @Query("select o from OrderProduct o where o.productId in (11,22) and o.orderProdState=4")
    public List<OrderProduct> findAllByProductId();
}
