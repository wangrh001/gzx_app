package com.bangnd.cbs.repository;

import com.bangnd.cbs.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    public Product findByProductId(@Param(value="productId") long id);

    @Query("select p from Product p where p.productType=:productType and p.productState =:productState")
    public List<Product> findProductByProductType(@Param(value="productType") long productType,
                                                   @Param(value = "productState") long productState);
}
