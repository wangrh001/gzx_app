package com.bangnd.sales.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import org.springframework.ui.Model;

import java.util.*;

import com.dashu.AutoBulider.config.*;
import com.bangnd.sales.web.*;
import com.bangnd.sales.entity.*;
import com.bangnd.sales.form.*;
import com.bangnd.sales.service.*;
import com.bangnd.sales.service.impl.*;
import com.bangnd.sales.vo.*;

@Controller
public class AgentController {
    @Resource
    private AgentService agentService;

    @RequestMapping("/agent/home")
    public String home(Model model, AgentSearchForm agentSearchForm) {
        List<Agent> agents = agentService.getAgentList(agentSearchForm);
        List<AgentVO> agentVOs = new ArrayList<>();
        if (agents != null) {
            for (Agent agent : agents) {
                AgentVO agentVO = new AgentVO();
                agentVO.setName(agent.getName());
                agentVO.setApplyDate(agent.getApplyDate());
                agentVOs.add(agentVO);
            }
        }
        model.addAttribute("agentVOs", agentVOs);
        return "/agent/agentList";
    }

    @RequestMapping("/agent/toAdd")
    public String toAdd(Model model) {
        Agent agent = new Agent();
        model.addAttribute("agent", agent);
        return "/agent/agentAdd";
    }

    @RequestMapping("/agent/add")
    public String add(Agent agent) {
        agent.setState(ConstantCfg.ORDER_STATE_INITIAL);
        agent.setCreator(0);
        agent.setCreateTime(new Date());
        agentService.save(agent);
        return "redirect:/agent/home";
    }

    @RequestMapping("/agent/toModify")
    public String toModify(Model model, Long id) {
        Agent agent = agentService.getAgentById(id);
        model.addAttribute("agent", agent);
        return "/agent/agentAdd";
    }

    @RequestMapping("/agent/modify")
    public String modify(Agent agent, Long id) {
        Agent oldAgent = agentService.getAgentById(id);
        oldAgent.setName(agent.getName());
        oldAgent.setApplyDate(agent.getApplyDate());
        oldAgent.setUpdator(0);
        oldAgent.setUpdateTime(new Date());
        agentService.merge(oldAgent);
        return "redirect:/agent/toModify?id=" + id;
    }

    @RequestMapping("/agent/delete")
    public String delete(Long id) {
        Agent oldAgent = agentService.getAgentById(id);
        oldAgent.setState(0);
        oldAgent.setUpdator(0);
        oldAgent.setUpdateTime(new Date());
        agentService.merge(oldAgent);
        return "redirect:/agent/home";
    }
}