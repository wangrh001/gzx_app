package com.bangnd.cbs.entity;

import javax.persistence.*;

@Entity
@Table(name="cfg_order_doc_type")
public class OrderDocType {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String chName;
    @Column
    private String enName;
    @Column
    private String fileDesc;
    @Column
    private String needCondition;
    @Column
    private String fileType;

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChName() {
        return chName;
    }

    public void setChName(String chName) {
        this.chName = chName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getFileDesc() {
        return fileDesc;
    }

    public void setFileDesc(String fileDesc) {
        this.fileDesc = fileDesc;
    }

    public String getNeedCondition() {
        return needCondition;
    }

    public void setNeedCondition(String needCondition) {
        this.needCondition = needCondition;
    }
}
