package com.bangnd.sales.service;

import com.bangnd.sales.entity.Agent;
import com.bangnd.sales.form.AgentSearchForm;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AgentService {
    public Page<Agent> getAgentList(Integer pageNum, int size, AgentSearchForm agentSearchForm);

    public void save(Agent agent);

    public Agent getAgentById(long id);

    public void merge(Agent agent);

    public List<Agent> getOutAllAgents();

    public void bandUser(long agentId, long userId, String userName);

    public Agent getAgentByUserId(long userId);

    public List<Agent> getAgentByAgentName(String agentName);

    public Agent getAgentByEmployeeId(long empolyeeId);

    public List<Agent> getAgentByGroupId(long groupId);


}