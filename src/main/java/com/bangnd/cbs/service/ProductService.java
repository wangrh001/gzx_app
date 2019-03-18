package com.bangnd.cbs.service;

import com.bangnd.cbs.entity.Product;
import com.bangnd.cbs.form.ProductSearchForm;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    public Page<Product> getProductList(Integer pageNum, int size, ProductSearchForm productSearchForm);

    public void save(Product product);

    public Product getProductById(int id);

    public void merge(Product product);

    List<Product> getProductsByType(int id);

    List<Product> getInterestProduct();

    List<Product> getAllProduct();
}