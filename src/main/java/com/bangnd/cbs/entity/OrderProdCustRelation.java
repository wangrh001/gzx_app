package com.bangnd.cbs.entity;

import javax.persistence.*;


/**
 * 订单和产品表关系：一对多
 * 订单产品和客户关系：可以一对多、一对一、多对一、多对多
 */

@Entity
@Table(name="t_cbs_order_prodCust")
public class OrderProdCustRelation {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private long orderId;

    @Column
    private long orderProductId;

    @Column
    private long customerId;

    @Column
    private long identityType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(long orderProductId) {
        this.orderProductId = orderProductId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getIdentityType() {
        return identityType;
    }

    public void setIdentityType(long identityType) {
        this.identityType = identityType;
    }
}
