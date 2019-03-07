package com.bangnd.ums.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_ums_user")
public class User {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private String userName;

    @Column
    private String password;

    @Column
    private int state;

    //最后一次登录时间
    @Column
    private Date lastLogInTime;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getLastLogInTime() {
        return lastLogInTime;
    }

    public void setLastLogInTime(Date lastLogInTime) {
        this.lastLogInTime = lastLogInTime;
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
