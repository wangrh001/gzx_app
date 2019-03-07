package com.bangnd.cbs.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_cbs_order_doc")
public class OrderDocument {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private long orderId;

    @Column
    private String originaName;

    @Column
    private String originalFilePath;

    @Column
    private String UUIDName;

    @Column
    private String UUIDNamedFilePath;

    @Column
    private String condenseNamePath;

    @Column
    private int docType;

    @Column
    private int state;

    @Column
    private Date createTime;

    @Column
    private int creator;

    @Column
    private Date updateTime;

    @Column
    private int updator;

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

    public String getOriginaName() {
        return originaName;
    }

    public void setOriginaName(String originaName) {
        this.originaName = originaName;
    }

    public String getOriginalFilePath() {
        return originalFilePath;
    }

    public void setOriginalFilePath(String originalFilePath) {
        this.originalFilePath = originalFilePath;
    }

    public String getUUIDName() {
        return UUIDName;
    }

    public void setUUIDName(String UUIDName) {
        this.UUIDName = UUIDName;
    }

    public String getUUIDNamedFilePath() {
        return UUIDNamedFilePath;
    }

    public void setUUIDNamedFilePath(String UUIDNamedFilePath) {
        this.UUIDNamedFilePath = UUIDNamedFilePath;
    }

    public String getCondenseNamePath() {
        return condenseNamePath;
    }

    public void setCondenseNamePath(String condenseNamePath) {
        this.condenseNamePath = condenseNamePath;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getUpdator() {
        return updator;
    }

    public void setUpdator(int updator) {
        this.updator = updator;
    }

    public int getDocType() {
        return docType;
    }

    public void setDocType(int docType) {
        this.docType = docType;
    }
}
