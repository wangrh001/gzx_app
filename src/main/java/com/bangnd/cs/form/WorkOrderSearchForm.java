package com.bangnd.cs.form;
import javax.persistence.*;
import java.util.*;
public class WorkOrderSearchForm {@Column 
public String csName;@Column 
public String cstype;@Column 
public String orderId;@Column 
public String customerName;@Column 
public String csState;public String getCsName(){return csName;}public String getCstype(){return cstype;}public String getOrderId(){return orderId;}public String getCustomerName(){return customerName;}public String getCsState(){return csState;}public void setCsName(String csName){this.csName=csName;}public void setCstype(String cstype){this.cstype=cstype;}public void setOrderId(String orderId){this.orderId=orderId;}public void setCustomerName(String customerName){this.customerName=customerName;}public void setCsState(String csState){this.csState=csState;}}