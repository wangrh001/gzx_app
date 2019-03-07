package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.Product;
import com.bangnd.cbs.service.*;
import com.bangnd.cbs.form.ProductSearchForm;

import java.util.*;

import com.bangnd.cbs.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductList(ProductSearchForm productSearchForm) {
        Specification specification = new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (productSearchForm.getProductName() != null && !"".equals(productSearchForm.getProductName())) {
                    predicates.add(cb.like(root.get("productName").as(String.class), "%" + productSearchForm.getProductName() + "%"));
                }
                if (productSearchForm.getBankId() != null && !"".equals(productSearchForm.getBankId())) {
                    if ("0".equals(productSearchForm.getBankId())) {
                        predicates.add(cb.notEqual(root.get("bankId"), productSearchForm.getBankId()));
                    } else {
                        predicates.add(cb.equal(root.get("bankId"), productSearchForm.getBankId()));
                    }
                }
                if (productSearchForm.getProductType() != null && !"".equals(productSearchForm.getProductType())) {
                    if ("0".equals(productSearchForm.getProductType())) {
                        predicates.add(cb.notEqual(root.get("productType"), productSearchForm.getProductType()));
                    } else {
                        predicates.add(cb.equal(root.get("productType"), productSearchForm.getProductType()));
                    }
                }
//                if (productSearchForm.getInterestWay() != null && !"".equals(productSearchForm.getInterestWay())) {
//                    if ("0".equals(productSearchForm.getInterestWay())) {
//                        predicates.add(cb.notEqual(root.get("interestWay"), productSearchForm.getInterestWay()));
//                    } else {
//                        predicates.add(cb.equal(root.get("interestWay"), productSearchForm.getInterestWay()));
//                    }
//                }
                predicates.add(cb.notEqual(root.get("state").as(Integer.class), new Integer(100)));
                Predicate[] p = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(p));
            }
        };
        return productRepository.findAll(specification);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void merge(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getProductsByType(int id) {
        return productRepository.findAllByProductType(id);
    }

    @Override
    public List<Product> getInterestProduct(){
        return productRepository.findAllByBusiType();
    }
}