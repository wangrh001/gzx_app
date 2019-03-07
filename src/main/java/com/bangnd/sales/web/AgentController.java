package com.bangnd.sales.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import org.springframework.ui.Model;

import java.util.*;

import com.bangnd.util.cfg.ConstantCfg;
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
    @Resource
    AgentBusinessTypeService agentBusinessTypeService;
    @Resource
    AgentChannelTypeService agentChannelTypeService;

    @RequestMapping("/sales/agent")
    public String home(Model model, AgentSearchForm agentSearchForm) {
        List<Agent> agents = agentService.getAgentList(agentSearchForm);
        model.addAttribute("businessTypes", agentBusinessTypeService.getAll());
        model.addAttribute("channelTypes", agentChannelTypeService.getAll());
        List<AgentVO> agentVOs = new ArrayList<>();
        if (agents != null) {
            for (Agent agent : agents) {
                AgentVO agentVO = new AgentVO();
                agentVO.setId(agent.getId());
                agentVO.setName(agent.getName());
                agentVO.setBusinessTypeName((agentBusinessTypeService.getAgentBusinessTypeById(agent.getBusinessType())).getName());
                agentVO.setPhoneNO(agent.getPhoneNO());
                agentVO.setCompanyName(agent.getCompanyName());
                agentVOs.add(agentVO);
            }
        }
        model.addAttribute("agentVOs", agentVOs);
        return "/sales/agentList";
    }

    @RequestMapping("/sales/agent/toAdd")
    public String toAdd(Model model) {
        Agent agent = new Agent();
        model.addAttribute("agent", agent);
        model.addAttribute("businessTypes", agentBusinessTypeService.getAll());
        model.addAttribute("channelTypes", agentChannelTypeService.getAll());
        return "/sales/agentAdd";
    }

    @RequestMapping("/sales/agent/add")
    public String add(Agent agent) {
        agent.setState(ConstantCfg.ORDER_STATE_INITIAL);
        agent.setCreator(0);
        agent.setCreateTime(new Date());
        agentService.save(agent);
        return "redirect:/sales/agent";
    }

    @RequestMapping("/sales/agent/toModify")
    public String toModify(Model model, Long id) {
        Agent agent = agentService.getAgentById(id);
        model.addAttribute("businessTypes", agentBusinessTypeService.getAll());
        model.addAttribute("channelTypes", agentChannelTypeService.getAll());
        model.addAttribute("agent", agent);
        return "/sales/agentAdd";
    }

    @RequestMapping("/sales/agent/modify")
    public String modify(Agent agent, Long id) {
        Agent oldAgent = agentService.getAgentById(id);
        oldAgent.setName(agent.getName());
        oldAgent.setBusinessType(agent.getBusinessType());
        oldAgent.setChannelType(agent.getChannelType());
        oldAgent.setBankCode(agent.getBankCode());
        oldAgent.setCooperateBeginDate(agent.getCooperateBeginDate());
        oldAgent.setCooperateEndDate(agent.getCooperateEndDate());
        oldAgent.setCentiCode(agent.getCentiCode());
        oldAgent.setPhoneNO(agent.getPhoneNO());
        oldAgent.setCompanyName(agent.getCompanyName());
        oldAgent.setUserName(agent.getUserName());
        oldAgent.setJobYears(agent.getJobYears());
        oldAgent.setUpdator(0);
        oldAgent.setUpdateTime(new Date());
        agentService.merge(oldAgent);
        return "redirect:/sales/agent/toModify?id=" + id;
    }

    @RequestMapping("/sales/agent/delete")
    public String delete(Long id) {
        Agent oldAgent = agentService.getAgentById(id);
        oldAgent.setState(100);
        oldAgent.setUpdator(0);
        oldAgent.setUpdateTime(new Date());
        agentService.merge(oldAgent);
        return "redirect:/sales/agent";
    }
}