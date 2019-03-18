package com.bangnd.ums.service;

import com.bangnd.ums.entity.User;
import com.bangnd.ums.form.UserSearchForm;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    public User getUserByUserId(long id);

    public User getUserByUserName(String userName);

    public boolean verifyUserName(String userName);

    public boolean verifyPassword(String userName, String password);

    public void save(User user);

    public void changePsd(String userName, String password);

    public User getUserById(long id);

    public void merge(User user);

    public Page<User> getUserList(Integer pageNum, int size, UserSearchForm userSearchForm);

    public List<User> getAll();
}