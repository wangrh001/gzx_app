package com.bangnd.cs.entity;
import javax.persistence.*;@Entity 
@Table(name="cfg_workOrder_cstype") 
public class WorkOrderCstype{ 
@Id 
@GeneratedValue 
private int id;
@Column(nullable = false)
private String name;
public int getId() {
return id;
}
public void setId(int id) {
this.id = id;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}}