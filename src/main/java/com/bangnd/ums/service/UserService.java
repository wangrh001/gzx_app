package com.bangnd.ums.service;

import com.bangnd.ums.entity.User;

public interface UserService {
    public User getUserByUserName(String userName);
    public boolean verifyUserName(String userName);
    public boolean verifyPassword(String userName,String password);
    public void save(User user);
    public void changePsd(String userName,String password);
}
