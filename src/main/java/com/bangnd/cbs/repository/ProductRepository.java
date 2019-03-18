package com.bangnd.cbs.repository;

import com.bangnd.cbs.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor {
    public Product findById(@Param(value = "id") long id);

    List<Product> findByStateNot(@Param(value = "status") int status);

    List<Product> findAllByProductType(@Param(value = "busiType") int id);

    @Query("select p from Product p where p.busiType in (3,4) and p.state<>100")
    List<Product> findAllByBusiType();

    @Query("select p from Product p where p.state<>100")
    List<Product> findAllByState();
}