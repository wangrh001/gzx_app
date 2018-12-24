package com.bangnd.sales.service.impl;

import com.bangnd.sales.entity.*;
import com.bangnd.sales.service.*;
import com.bangnd.sales.repository.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentChannelTypeServiceImpl implements AgentChannelTypeService {
    @Autowired
    private AgentChannelTypeRepository agentChannelTypeRepository;

    @Override
    public List<AgentChannelType> getAll() {
        return agentChannelTypeRepository.findAll();
    }

    @Override
    public AgentChannelType getAgentChannelTypeById(long id) {
        return agentChannelTypeRepository.findOne(id);
    }
}