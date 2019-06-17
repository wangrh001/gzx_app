package com.bangnd.util.service;

import com.bangnd.util.entity.OrganType;

import java.util.List;

public interface OrganTypeService {
    public List<OrganType> getAll();

    public OrganType getOrganType(int id);

    public OrganType getOrganTypeByName(String name);
}
