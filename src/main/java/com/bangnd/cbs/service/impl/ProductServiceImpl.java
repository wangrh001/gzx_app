package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.Product;
import com.bangnd.cbs.repository.ProductRepository;
import com.bangnd.cbs.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product getProduct(long id) {
        return productRepository.findByProductId(id);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    /**
     * 选出特定类型的可用产品
     * @param productType
     * @return
     */
    @Override
    public List<Product> getProductsByType(long productType) {
        return productRepository.findProductByProductType(productType,1);
    }


}
