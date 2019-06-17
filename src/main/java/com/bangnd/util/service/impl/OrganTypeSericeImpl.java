package com.bangnd.util.service.impl;

import com.bangnd.util.entity.OrganType;
import com.bangnd.util.repository.OrganTypeRepository;
import com.bangnd.util.service.OrganTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganTypeSericeImpl implements OrganTypeService {
    @Autowired
    OrganTypeRepository organTypeRepository;

    @Override
    public List<OrganType> getAll() {
        return organTypeRepository.findAll();
    }

    @Override
    public OrganType getOrganType(int id) {
        return organTypeRepository.getOrganTypeById(id);
    }

    @Override
    public OrganType getOrganTypeByName(String name) {
        return organTypeRepository.getOrganTypeByName(name);
    }
}
