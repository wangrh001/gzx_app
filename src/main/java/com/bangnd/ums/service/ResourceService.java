package com.bangnd.ums.service;

import com.bangnd.ums.entity.Resource;
import com.bangnd.ums.form.ResourceSearchForm;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ResourceService {
    public Page<Resource> getResourceList(Integer pageNum, int size, ResourceSearchForm resourceSearchForm);

    public void save(Resource resource);

    public Resource getResourceById(long id);

    public void merge(Resource resource);

//    public String getMenuTreeString(long id);

    public String getMenuTreeString(List<Resource> resources);

    public List<Resource> getAll();
}