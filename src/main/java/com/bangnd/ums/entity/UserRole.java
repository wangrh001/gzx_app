package com.bangnd.ums.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_ums_userRole")
public class UserRole {
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
    private long roleId;
    @Column
    private long userId;

    public long getRoleId() {
        return roleId;
    }

    public long getUserId() {
        return userId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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