package com.bangnd.sales.service;

import com.bangnd.sales.entity.*;

import java.util.List;

public interface AgentBusinessTypeService {
    public List<AgentBusinessType> getAll();

    public AgentBusinessType getAgentBusinessTypeById(Integer ind);
}