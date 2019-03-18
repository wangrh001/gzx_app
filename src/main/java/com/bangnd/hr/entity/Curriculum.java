package com.bangnd.hr.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_hr_curriculum")
public class Curriculum {
    @Id
    @GeneratedValue
    public long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public String name;
    @Column
    public int type;
    @Column
    public String teacherName;
    @Column
    public int empId;
    @Column
    public int posId;

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public int getEmpId() {
        return empId;
    }

    public int getPosId() {
        return posId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setPosId(int posId) {
        this.posId = posId;
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
}