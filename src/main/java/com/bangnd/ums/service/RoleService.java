package com.bangnd.ums.service;

import com.bangnd.ums.entity.Role;
import com.bangnd.ums.form.RoleSearchForm;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RoleService {
    public Page<Role> getRoleList(Integer pageNum, int size, RoleSearchForm roleSearchForm);

    public void save(Role role);

    public Role getRoleById(long id);

    public void merge(Role role);

    public List<Role> getAll();
}