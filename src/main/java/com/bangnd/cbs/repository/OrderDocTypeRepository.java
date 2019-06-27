package com.bangnd.cbs.repository;

import com.bangnd.cbs.entity.OrderDocType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderDocTypeRepository extends JpaRepository<OrderDocType,Integer> {

    @Query("select d from OrderDocType  d where chName = :chName")
    public OrderDocType findOneByName(@Param(value = "chName") String docName);
}
