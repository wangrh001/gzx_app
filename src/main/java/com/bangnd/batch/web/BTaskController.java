package com.bangnd.batch.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import org.springframework.ui.Model;

import java.util.*;

import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.batch.web.*;
import com.bangnd.batch.entity.*;
import com.bangnd.batch.form.*;
import com.bangnd.batch.service.*;
import com.bangnd.batch.service.impl.*;
import com.bangnd.batch.vo.*;

@Controller
public class BTaskController {
    @Resource
    private BTaskService BTaskService;
    @Resource
    BTaskResultService BTaskResultService;

    @RequestMapping("/batch/BTask")
    public String home(Model model, BTaskSearchForm BTaskSearchForm) {
        List<BTask> BTasks = BTaskService.getBTaskList(BTaskSearchForm);
        model.addAttribute("results", BTaskResultService.getAll());
        List<BTaskVO> BTaskVOs = new ArrayList<>();
        if (BTasks != null) {
            for (BTask BTask : BTasks) {
                BTaskVO BTaskVO = new BTaskVO();
                BTaskVO.setId(BTask.getId());
                BTaskVO.setBatchName(BTask.getBatchName());
                BTaskVO.setBatchId(BTask.getBatchId());
                BTaskVO.setStartTime(BTask.getStartTime());
                BTaskVO.setEndTime(BTask.getEndTime());
                BTaskVO.setResultName((BTaskResultService.getBTaskResultById(BTask.getResult())).getName());
                BTaskVO.setErrorDesc(BTask.getErrorDesc());
                BTaskVOs.add(BTaskVO);
            }
        }
        model.addAttribute("BTaskVOs", BTaskVOs);
        return "/batch/BTaskList";
    }

    @RequestMapping("/batch/BTask/toAdd")
    public String toAdd(Model model) {
        BTask BTask = new BTask();
        model.addAttribute("BTask", BTask);
        model.addAttribute("results", BTaskResultService.getAll());
        return "/batch/BTaskAdd";
    }

    @RequestMapping("/batch/BTask/add")
    public String add(BTask BTask) {
        BTask.setState(ConstantCfg.ORDER_STATE_INITIAL);
        BTask.setCreator(0);
        BTask.setCreateTime(new Date());
        BTaskService.save(BTask);
        return "redirect:/batch/BTask";
    }

    @RequestMapping("/batch/BTask/toModify")
    public String toModify(Model model, Long id) {
        BTask BTask = BTaskService.getBTaskById(id);
        model.addAttribute("BTask", BTask);
        model.addAttribute("results", BTaskResultService.getAll());
        return "/batch/BTaskAdd";
    }

    @RequestMapping("/batch/BTask/modify")
    public String modify(BTask BTask, Long id) {
        BTask oldBTask = BTaskService.getBTaskById(id);
        oldBTask.setBatchName(BTask.getBatchName());
        oldBTask.setStartTime(BTask.getStartTime());
        oldBTask.setResult(BTask.getResult());
        oldBTask.setUpdator(0);
        oldBTask.setUpdateTime(new Date());
        BTaskService.merge(oldBTask);
        return "redirect:/batch/BTask/toModify?id=" + id;
    }

    @RequestMapping("/batch/BTask/delete")
    public String delete(Long id) {
        BTask oldBTask = BTaskService.getBTaskById(id);
        oldBTask.setState(100);
        oldBTask.setUpdator(0);
        oldBTask.setUpdateTime(new Date());
        BTaskService.merge(oldBTask);
        return "redirect:/batch/BTask";
    }
}