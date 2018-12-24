package com.bangnd.sales.service;

import com.bangnd.sales.entity.*;

import java.util.List;

public interface AgentChannelTypeService {
    public List<AgentChannelType> getAll();

    public AgentChannelType getAgentChannelTypeById(long ind);
}