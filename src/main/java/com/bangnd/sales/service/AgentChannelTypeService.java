package com.bangnd.sales.service;

import com.bangnd.sales.entity.AgentChannelType;

import java.util.List;

public interface AgentChannelTypeService {
    public List<AgentChannelType> getAll();

    public List<AgentChannelType> getOutSalesTypes();

    public AgentChannelType getAgentChannelTypeById(Integer ind);
}