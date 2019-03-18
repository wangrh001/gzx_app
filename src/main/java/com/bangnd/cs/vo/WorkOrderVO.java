package com.bangnd.cs.vo;

import javax.persistence.Column;
public class WorkOrderVO {@Column
public long id;public long getId() { return id; }public void setId(long id) { this.id = id; }@Column 
public String csName;@Column 
public String cstypeName;@Column 
public long orderId;@Column 
public String customerName;@Column 
public String csStateName;public String getCsName(){return csName;}public String getCstypeName(){return cstypeName;}public long getOrderId(){return orderId;}public String getCustomerName(){return customerName;}public String getCsStateName(){return csStateName;}public void setCsName(String csName){this.csName=csName;}public void setCstypeName(String cstypeName){this.cstypeName=cstypeName;}public void setOrderId(long orderId){this.orderId=orderId;}public void setCustomerName(String customerName){this.customerName=customerName;}public void setCsStateName(String csStateName){this.csStateName=csStateName;}}