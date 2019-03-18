package com.bangnd.finance.repository;

import com.bangnd.finance.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long>, JpaSpecificationExecutor {
    public Payment findById(@Param(value = "id") long id);

    List<Payment> findByStateNot(@Param(value = "status") int status);

    //获取该订单产品表中所有确认的费用
    @Query("select p from Payment p where orderProductId = :orderProductId and p.state<>100 and p.payState=6")
    List<Payment> findAllByorderProductId(@Param(value="orderProductId") long id);
}