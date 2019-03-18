package com.bangnd.ums.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_ums_resource")
public class Resource {
    @Id
    @GeneratedValue
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    private String name;
    @Column
    private String resUrl;
    @Column
    private int type;
    @Column
    private long parentId;

    public String getName() {
        return name;
    }

    public String getResUrl() {
        return resUrl;
    }

    public int getType() {
        return type;
    }

    public long getParentId() {
        return parentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    @Column
    private int state;
    @Column
    private long creator;
    @Column
    private Date createTime;
    @Column
    private long updator;
    @Column
    private Date updateTime;
    @Column
    private String columnName;
    @Column
    private String valueSet;

    public int getState() {
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
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getValueSet() {
        return valueSet;
    }

    public void setValueSet(String valueSet) {
        this.valueSet = valueSet;
    }
}