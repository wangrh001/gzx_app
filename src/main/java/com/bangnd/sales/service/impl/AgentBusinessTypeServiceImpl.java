package com.bangnd.sales.service.impl;

import com.bangnd.sales.entity.AgentBusinessType;
import com.bangnd.sales.repository.AgentBusinessTypeRepository;
import com.bangnd.sales.service.AgentBusinessTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentBusinessTypeServiceImpl implements AgentBusinessTypeService {
    @Autowired
    private AgentBusinessTypeRepository agentBusinessTypeRepository;

    @Override
    public List<AgentBusinessType> getAll() {
        return agentBusinessTypeRepository.findAll();
    }

    @Override
    public AgentBusinessType getAgentBusinessTypeById(Integer id) {
        return agentBusinessTypeRepository.findOne(id);
    }
}