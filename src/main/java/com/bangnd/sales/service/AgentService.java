package com.bangnd.sales.service;

import com.bangnd.sales.entity.Agent;
import com.bangnd.sales.form.AgentSearchForm;

import java.util.List;

public interface AgentService {
    public List<Agent> getAgentList(AgentSearchForm agentSearchForm);

    public void save(Agent agent);

    public Agent getAgentById(long id);

    public void merge(Agent agent);
}