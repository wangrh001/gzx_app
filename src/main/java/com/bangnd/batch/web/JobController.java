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
public class JobController {
    @Resource
    private JobService jobService;
    @Resource
    JobTypeService jobTypeService;

    @RequestMapping("/batch/job")
    public String home(Model model, JobSearchForm jobSearchForm) {
        List<Job> jobs = jobService.getJobList(jobSearchForm);
        model.addAttribute("types", jobTypeService.getAll());
        List<JobVO> jobVOs = new ArrayList<>();
        if (jobs != null) {
            for (Job job : jobs) {
                JobVO jobVO = new JobVO();
                jobVO.setId(job.getId());
                jobVO.setBatchName(job.getBatchName());
                jobVO.setTypeName((jobTypeService.getJobTypeById(job.getType())).getName());
                jobVO.setPeriodNum(job.getPeriodNum());
                jobVO.setLastTime(job.getLastTime());
                jobVO.setStartTime(job.getStartTime());
                jobVO.setNextTime(job.getNextTime());
                jobVOs.add(jobVO);
            }
        }
        model.addAttribute("jobVOs", jobVOs);
        return "/batch/jobList";
    }

    @RequestMapping("/batch/job/toAdd")
    public String toAdd(Model model) {
        Job job = new Job();
        model.addAttribute("job", job);
        model.addAttribute("types", jobTypeService.getAll());
        return "/batch/jobAdd";
    }

    @RequestMapping("/batch/job/add")
    public String add(Job job) {
        job.setState(ConstantCfg.ORDER_STATE_INITIAL);
        job.setCreator(0);
        job.setCreateTime(new Date());
        jobService.save(job);
        return "redirect:/batch/job";
    }

    @RequestMapping("/batch/job/toModify")
    public String toModify(Model model, Long id) {
        Job job = jobService.getJobById(id);
        model.addAttribute("job", job);
        model.addAttribute("types", jobTypeService.getAll());
        return "/batch/jobAdd";
    }

    @RequestMapping("/batch/job/modify")
    public String modify(Job job, Long id) {
        Job oldJob = jobService.getJobById(id);
        oldJob.setBatchName(job.getBatchName());
        oldJob.setType(job.getType());
        oldJob.setPeriodNum(job.getPeriodNum());
        oldJob.setStartTime(job.getStartTime());
        oldJob.setNextTime(job.getNextTime());
        oldJob.setUpdator(0);
        oldJob.setUpdateTime(new Date());
        jobService.merge(oldJob);
        return "redirect:/batch/job/toModify?id=" + id;
    }

    @RequestMapping("/batch/job/delete")
    public String delete(Long id) {
        Job oldJob = jobService.getJobById(id);
        oldJob.setState(100);
        oldJob.setUpdator(0);
        oldJob.setUpdateTime(new Date());
        jobService.merge(oldJob);
        return "redirect:/batch/job";
    }
}