package com.bangnd.sales.repository;

import com.bangnd.sales.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AgentRepository extends JpaRepository<Agent, Long>, JpaSpecificationExecutor {
    public Agent findById(@Param(value = "id") long id);

    List<Agent> findByStateNot(@Param(value = "status") int status);

    @Query("select a from Agent a where a.state<>100 and a.channelType=2")
    public List<Agent> getOutAllAgents();

    @Query("select a from Agent a where  a.userId=:userId")
    public Agent findOneByUserId(@Param(value = "userId") long userId);
}