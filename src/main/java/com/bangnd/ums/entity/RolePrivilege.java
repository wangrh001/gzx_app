package com.bangnd.ums.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="t_ums_role_privilege")
public class RolePrivilege {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private long roleId;

    @Column
    private long resId;

    //1、可访问（白名单）；2、不可访问（黑名单）
    @Column
    private int privilegeType;

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

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public long getResId() {
        return resId;
    }

    public void setResId(long resId) {
        this.resId = resId;
    }

    public int getPrivilegeType() {
        return privilegeType;
    }

    public void setPrivilegeType(int privilegeType) {
        this.privilegeType = privilegeType;
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
}
