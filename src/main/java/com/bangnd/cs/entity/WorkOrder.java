package com.bangnd.cs.entity;import javax.persistence.*;import java.math.BigDecimal;import java.util.Date;@Entity@Table(name="t_cs_workOrder")public class WorkOrder{@Id@GeneratedValue public long id;public long getId() { return id; }public void setId(long id) { this.id = id; }@Column 
public String csName;@Column 
public int cstype;@Column 
public String csDesc;@Column 
public long orderId;@Column 
public String customerName;@Column 
public long customerId;@Column 
public int csState;public String getCsName(){return csName;}public int getCstype(){return cstype;}public String getCsDesc(){return csDesc;}public long getOrderId(){return orderId;}public String getCustomerName(){return customerName;}public long getCustomerId(){return customerId;}public int getCsState(){return csState;}public void setCsName(String csName){this.csName=csName;}public void setCstype(int cstype){this.cstype=cstype;}public void setCsDesc(String csDesc){this.csDesc=csDesc;}public void setOrderId(long orderId){this.orderId=orderId;}public void setCustomerName(String customerName){this.customerName=customerName;}public void setCustomerId(long customerId){this.customerId=customerId;}public void setCsState(int csState){this.csState=csState;}@Column 
private int state;@Column 
private long creator;@Column 
private Date createTime;@Column 
private long updator;@Column 
private Date updateTime;public int getState() {
 return state;
}
public void setState(int state) {
this.state = state;
}
public long getCreator() {
return creator;
}
public void setCreator(long creator) {
this.creator = creator;
}
public Date getCreateTime() {
return createTime;
}
public void setCreateTime(Date createTime) {
this.createTime = createTime;
}
public long getUpdator() {
return updator;
}
public void setUpdator(long updator) {
this.updator = updator;
}
public Date getUpdateTime() {
return updateTime;
}
public void setUpdateTime(Date updateTime) {
this.updateTime = updateTime;
}}