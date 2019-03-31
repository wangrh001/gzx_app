package com.bangnd.sales.service.impl;

import com.bangnd.sales.entity.AgentChannelType;
import com.bangnd.sales.repository.AgentChannelTypeRepository;
import com.bangnd.sales.service.AgentChannelTypeService;
import com.bangnd.util.cfg.ConstantCfg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentChannelTypeServiceImpl implements AgentChannelTypeService {
    @Autowired
    private AgentChannelTypeRepository agentChannelTypeRepository;

    @Override
    public List<AgentChannelType> getAll() {
        return agentChannelTypeRepository.findAll();
    }

    @Override
    public List<AgentChannelType> getOutSalesTypes() {
        return agentChannelTypeRepository.findAllByType(ConstantCfg.OUT_SALES_2);
    }

    @Override
    public AgentChannelType getAgentChannelTypeById(Integer id) {
        return agentChannelTypeRepository.findOne(id);
    }
}