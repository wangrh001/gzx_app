package com.bangnd.cs.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import org.springframework.ui.Model;

import java.util.*;

import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.cs.web.*;
import com.bangnd.cs.entity.*;
import com.bangnd.cs.form.*;
import com.bangnd.cs.service.*;
import com.bangnd.cs.service.impl.*;
import com.bangnd.cs.vo.*;

@Controller
public class KnowledgeController {
    @Resource
    private KnowledgeService knowledgeService;
    @Resource
    KnowledgeQuestionTypeService knowledgeQuestionTypeService;

    @RequestMapping("/cs/knowledge")
    public String home(Model model, KnowledgeSearchForm knowledgeSearchForm) {
        List<Knowledge> knowledges = knowledgeService.getKnowledgeList(knowledgeSearchForm);
        model.addAttribute("questionTypes", knowledgeQuestionTypeService.getAll());
        List<KnowledgeVO> knowledgeVOs = new ArrayList<>();
        if (knowledges != null) {
            for (Knowledge knowledge : knowledges) {
                KnowledgeVO knowledgeVO = new KnowledgeVO();
                knowledgeVO.setId(knowledge.getId());
                knowledgeVO.setQuestionName(knowledge.getQuestionName());
                knowledgeVO.setQuestion(knowledge.getQuestion());
                knowledgeVOs.add(knowledgeVO);
            }
        }
        model.addAttribute("knowledgeVOs", knowledgeVOs);
        return "/cs/knowledgeList";
    }

    @RequestMapping("/cs/knowledge/toAdd")
    public String toAdd(Model model) {
        Knowledge knowledge = new Knowledge();
        model.addAttribute("knowledge", knowledge);
        model.addAttribute("questionTypes", knowledgeQuestionTypeService.getAll());
        return "/cs/knowledgeAdd";
    }

    @RequestMapping("/cs/knowledge/add")
    public String add(Knowledge knowledge) {
        knowledge.setState(ConstantCfg.ORDER_STATE_INITIAL);
        knowledge.setCreator(0);
        knowledge.setCreateTime(new Date());
        knowledgeService.save(knowledge);
        return "redirect:/cs/knowledge";
    }

    @RequestMapping("/cs/knowledge/toModify")
    public String toModify(Model model, Long id) {
        Knowledge knowledge = knowledgeService.getKnowledgeById(id);
        model.addAttribute("knowledge", knowledge);
        model.addAttribute("questionTypes", knowledgeQuestionTypeService.getAll());
        return "/cs/knowledgeAdd";
    }

    @RequestMapping("/cs/knowledge/modify")
    public String modify(Knowledge knowledge, Long id) {
        Knowledge oldKnowledge = knowledgeService.getKnowledgeById(id);
        oldKnowledge.setQuestionName(knowledge.getQuestionName());
        oldKnowledge.setQuestion(knowledge.getQuestion());
        oldKnowledge.setQuestionType(knowledge.getQuestionType());
        oldKnowledge.setAnswer(knowledge.getAnswer());
        oldKnowledge.setUpdator(0);
        oldKnowledge.setUpdateTime(new Date());
        knowledgeService.merge(oldKnowledge);
        return "redirect:/cs/knowledge/toModify?id=" + id;
    }

    @RequestMapping("/cs/knowledge/delete")
    public String delete(Long id) {
        Knowledge oldKnowledge = knowledgeService.getKnowledgeById(id);
        oldKnowledge.setState(100);
        oldKnowledge.setUpdator(0);
        oldKnowledge.setUpdateTime(new Date());
        knowledgeService.merge(oldKnowledge);
        return "redirect:/cs/knowledge";
    }
}