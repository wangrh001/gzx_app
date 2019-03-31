package com.bangnd.sales.repository;

import com.bangnd.sales.entity.AgentChannelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AgentChannelTypeRepository extends JpaRepository<AgentChannelType, Integer> {

    @Query("select a from AgentChannelType  a where a.type=:type or a.type = 0")
    public List<AgentChannelType> findAllByType(@Param(value = "type") int type);
}