package com.bangnd.cbs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_cbs_product")
public class Product {
    @Id
    @GeneratedValue
    private int productId;

}
