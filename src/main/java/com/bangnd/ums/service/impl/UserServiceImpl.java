package com.bangnd.ums.service.impl;

import com.bangnd.ums.entity.User;
import com.bangnd.ums.form.UserSearchForm;
import com.bangnd.ums.repository.UserRepository;
import com.bangnd.ums.service.UserService;
import com.bangnd.util.security.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public Page<User> getUserList(Integer pageNum, int size, UserSearchForm userSearchForm) {
        Specification specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                if (userSearchForm.getUserName() != null && !"".equals(userSearchForm.getUserName())) {
                    predicates.add(cb.like(root.get("userName").as(String.class), "%" + userSearchForm.getUserName() + "%"));
                }
                if (userSearchForm.getPassword() != null && !"".equals(userSearchForm.getPassword())) {
                    predicates.add(cb.like(root.get("password").as(String.class), "%" + userSearchForm.getPassword() + "%"));
                }
                predicates.add(cb.notEqual(root.get("state").as(Integer.class), new Integer(100)));
                Predicate[] p = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(p));
            }
        };

        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest((pageNum - 1), size, sort);
        Page<User> qyPage = this.userRepository.findAll(specification, pageable);
        return qyPage;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public void merge(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserByUserId(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User getUserByUserName(String userName) {
        return userRepository.findUserByUserName(userName);
    }

    //验证用户名是否存在
    @Override
    public boolean verifyUserName(String userName) {
        User user1 = userRepository.findUserByUserName(userName);
        boolean flag = false;
        if (user1 != null) {
            flag = true;
        }
        return flag;
    }

    //验证密码是否正确
    @Override
    public boolean verifyPassword(String userName, String password) {
        User user1 = userRepository.findUserByUserName(userName);
        boolean flag = false;
        if (user1 != null) {
            if (user1.getPassword().equals(MD5Util.getMD5(password, true, 32))) {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public void changePsd(String userName, String password) {
        System.out.println("userName=" + userName + ":password:" + password);
        User user = userRepository.findUserByUserName(userName);
        user.setPassword(MD5Util.getMD5(password, true, 32));
        user.setUpdator(user.getId());
        user.setUpdateTime(new Date());
        userRepository.save(user);
    }
}