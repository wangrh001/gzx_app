package com.bangnd.cbs.service;

import com.bangnd.cbs.entity.Product;

import java.util.List;

public interface ProductService {
    public Product getProduct(long id);
    //获取全部产品
    public List<Product> getAllProduct();
    //获取这一类产品
    public List<Product> getProductsByType(long productType);

}
