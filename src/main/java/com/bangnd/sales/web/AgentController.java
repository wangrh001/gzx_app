package com.bangnd.sales.web;

import com.bangnd.sales.entity.Agent;
import com.bangnd.sales.form.AgentSearchForm;
import com.bangnd.sales.service.AgentBusinessTypeService;
import com.bangnd.sales.service.AgentChannelTypeService;
import com.bangnd.sales.service.AgentService;
import com.bangnd.sales.vo.AgentVO;
import com.bangnd.util.cfg.ConstantCfg;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AgentController {
    @Resource
    private AgentService agentService;
    @Resource
    AgentBusinessTypeService agentBusinessTypeService;
    @Resource
    AgentChannelTypeService agentChannelTypeService;

    @RequestMapping("/sales/agent")
    public String home(Model model, @RequestParam(value="pageNum",required=false) String pageNum, AgentSearchForm agentSearchForm) {
        if(pageNum==null){
            pageNum="1";
        }
        Page<Agent> pages = agentService.getAgentList(Integer.valueOf(pageNum),ConstantCfg.NUM_PER_PAGE,agentSearchForm);
        model.addAttribute("businessTypes", agentBusinessTypeService.getAll());
        model.addAttribute("channelTypes", agentChannelTypeService.getAll());
        List<AgentVO> agentVOs = new ArrayList<>();
        if (pages != null) {
            for (Agent agent : pages) {
                AgentVO agentVO = new AgentVO();
                agentVO.setId(agent.getId());
                agentVO.setName(agent.getName());
                agentVO.setBusinessTypeName((agentBusinessTypeService.getAgentBusinessTypeById(agent.getBusinessType())).getName());
                agentVO.setPhoneNO(agent.getPhoneNO());
                agentVO.setCompanyName(agent.getCompanyName());
                agentVOs.add(agentVO);
            }
        }

        int pagenum=Integer.valueOf(pageNum);
        model.addAttribute("page",pages);
        model.addAttribute("pageNum",pagenum);
        model.addAttribute("totalPages",pages.getTotalPages());
        System.out.println("totalPages="+pages.getTotalPages());
        model.addAttribute("totalElements",pages.getTotalElements());
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