package com.bangnd.cbs.repository;

import com.bangnd.cbs.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface OrderProductRepository extends JpaRepository<OrderProduct,Long> {
    //public List<OrderProduct> getOrderProductList(@Param(value="orderId") long id);

    @Query("select o from OrderProduct o where orderId = :orderId and o.orderProdState<>0")
    public List<OrderProduct> findByOrderId(@Param(value="orderId") long id);

    public OrderProduct findById(@Param(value="id") long id);
}
