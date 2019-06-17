package com.bangnd.bridgecbs.repository;

import com.bangnd.bridgecbs.entity.Mortgage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MortgageRepository extends JpaRepository<Mortgage, Integer> {

    @Query("select m from Mortgage m where m.orderId=:orderId and m.state<>100")
    public List<Mortgage> findAllByOrderId(@Param(value = "orderId") Long orderId);

    @Query("select m from Mortgage m where m.mortgageId=:id and m.state<>100")
    public Mortgage findOneById(@Param(value = "id") Long id);
}
