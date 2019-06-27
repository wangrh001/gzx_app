package com.dashu.AutoBulider.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_data_model")
public class DataModel {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String tableNames;

    @Column
    private String sysName;

    //英文字段名
    @Column
    private String columnNameEn;

    //中文字段名
    @Column
    private String columnNameCh;

    //字段类型
    @Column
    private int columnType;

    //是否是离散字段
    @Column
    private int ifScatter;

    //离散
    @Column
    private List<String> scatterValue;

    //是否可以为空
    @Column
    private int ifNullable;

    //是否是查询字段
    @Column
    private int ifSearchColumn;

    //是否是业务日期，如果是，并且还是要根据这个日期进行查询，那么在searchForm中就要加上开始时间和结束时间
    @Column
    private int ifBusinessDate;

    //是否是列表显示字段
    @Column
    private int ifShowColumn;

    //是否可以修改
    @Column
    private int ifModifyable;

    @Column
    private int ifCreateScatter;
    @Column
    private String foreignObject;
    @Column
    private String whoObject;

    @Column
    private int length;
    @Column
    private int ifNeed;
    @Column
    private int ifMoreSelect;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTableNames() {
        return tableNames;
    }

    public void setTableNames(String tableNames) {
        this.tableNames = tableNames;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getColumnNameEn() {
        return columnNameEn;
    }

    public void setColumnNameEn(String columnNameEn) {
        this.columnNameEn = columnNameEn;
    }

    public String getColumnNameCh() {
        return columnNameCh;
    }

    public void setColumnNameCh(String columnNameCh) {
        this.columnNameCh = columnNameCh;
    }

    public int getColumnType() {
        return columnType;
    }

    public void setColumnType(int columnType) {
        this.columnType = columnType;
    }

    public int getIfScatter() {
        return ifScatter;
    }

    public void setIfScatter(int ifScatter) {
        this.ifScatter = ifScatter;
    }

    public List<String> getScatterValue() {
        return scatterValue;
    }

    public void setScatterValue(List<String> scatterValue) {
        this.scatterValue = scatterValue;
    }

    public int getIfNullable() {
        return ifNullable;
    }

    public void setIfNullable(int ifNullable) {
        this.ifNullable = ifNullable;
    }

    public int getIfSearchColumn() {
        return ifSearchColumn;
    }

    public void setIfSearchColumn(int ifSearchColumn) {
        this.ifSearchColumn = ifSearchColumn;
    }

    public int getIfShowColumn() {
        return ifShowColumn;
    }

    public void setIfShowColumn(int ifShowColumn) {
        this.ifShowColumn = ifShowColumn;
    }

    public int getIfModifyable() {
        return ifModifyable;
    }

    public void setIfModifyable(int ifModifyable) {
        this.ifModifyable = ifModifyable;
    }

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

    public int getIfBusinessDate() {
        return ifBusinessDate;
    }

    public void setIfBusinessDate(int ifBusinessDate) {
        this.ifBusinessDate = ifBusinessDate;
    }

    public int getIfCreateScatter() {
        return ifCreateScatter;
    }

    public void setIfCreateScatter(int ifCreateScatter) {
        this.ifCreateScatter = ifCreateScatter;
    }

    public String getForeignObject() {
        return foreignObject;
    }

    public void setForeignObject(String foreignObject) {
        this.foreignObject = foreignObject;
    }

    public String getWhoObject() {
        return whoObject;
    }

    public void setWhoObject(String whoObject) {
        this.whoObject = whoObject;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getIfNeed() {
        return ifNeed;
    }

    public void setIfNeed(int ifNeed) {
        this.ifNeed = ifNeed;
    }

    public int getIfMoreSelect() {
        return ifMoreSelect;
    }

    public void setIfMoreSelect(int ifMoreSelect) {
        this.ifMoreSelect = ifMoreSelect;
    }
}
