package com.bangnd.ums.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="t_user_behavior_log")
public class UserLoginLog {
    @Id
    @GeneratedValue
    private long id;

    @Column
    private long userId;

    @Column
    private Date behavior_time;

    //操作的某个资源，比如登录、登出、某个菜单
    @Column
    private long resourceId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getBehavior_time() {
        return behavior_time;
    }

    public void setBehavior_time(Date behavior_time) {
        this.behavior_time = behavior_time;
    }

    public long getResourceId() {
        return resourceId;
    }

    public void setResourceId(long resourceId) {
        this.resourceId = resourceId;
    }

}
