package com.bangnd.sales.repository;

import com.bangnd.sales.entity.TelSales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface TelSalesRepository extends JpaRepository<TelSales, Long>, JpaSpecificationExecutor {
    public TelSales findById(@Param(value = "id") long id);

    List<TelSales> findByStateNot(@Param(value = "status") int status);
}