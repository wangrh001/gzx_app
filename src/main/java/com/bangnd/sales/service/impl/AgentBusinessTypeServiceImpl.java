package com.bangnd.sales.service.impl;

import com.bangnd.sales.entity.*;
import com.bangnd.sales.service.*;
import com.bangnd.sales.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentBusinessTypeServiceImpl implements AgentBusinessTypeService {
    @Autowired
    private AgentBusinessTypeRepository agentBusinessTypeRepository;

    @Override
    public List<AgentBusinessType> getAll() {
        return agentBusinessTypeRepository.findAll();
    }

    @Override
    public AgentBusinessType getAgentBusinessTypeById(long id) {
        return agentBusinessTypeRepository.findOne(id);
    }
}