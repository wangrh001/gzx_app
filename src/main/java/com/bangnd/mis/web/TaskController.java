package com.bangnd.mis.web;

import com.bangnd.mis.entity.Task;
import com.bangnd.mis.form.TaskSearchForm;
import com.bangnd.mis.service.*;
import com.bangnd.mis.vo.TaskVO;
import com.bangnd.util.cfg.ConstantCfg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class TaskController {
    @Resource
    private TaskService taskService;
    @Resource
    TaskTypeService taskTypeService;
    @Resource
    TaskTaskPeriodService taskTaskPeriodService;
    @Resource
    TaskEndDateService taskEndDateService;
    @Resource
    TaskTaskStateService taskTaskStateService;

    @RequestMapping("/mis/task")
    public String home(Model model, TaskSearchForm taskSearchForm) {
        List<Task> tasks = taskService.getTaskList(taskSearchForm);
        model.addAttribute("types", taskTypeService.getAll());
        model.addAttribute("taskPeriods", taskTaskPeriodService.getAll());
        model.addAttribute("endDates", taskEndDateService.getAll());
        model.addAttribute("taskStates", taskTaskStateService.getAll());
        List<TaskVO> taskVOs = new ArrayList<>();
        if (tasks != null) {
            for (Task task : tasks) {
                TaskVO taskVO = new TaskVO();
                taskVO.setId(task.getId());
                taskVO.setTaskName(task.getTaskName());
                taskVO.setEndDateName((taskEndDateService.getTaskEndDateById(task.getEndDate())).getName());
                taskVO.setAmount(task.getAmount());
                taskVO.setTaskStateName((taskTaskStateService.getTaskTaskStateById(task.getTaskState())).getName());
                taskVO.setCompleteAmount(task.getCompleteAmount());
                taskVOs.add(taskVO);
            }
        }
        model.addAttribute("taskVOs", taskVOs);
        return "/mis/taskList";
    }

    @RequestMapping("/mis/task/toAdd")
    public String toAdd(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);
        model.addAttribute("types", taskTypeService.getAll());
        model.addAttribute("taskPeriods", taskTaskPeriodService.getAll());
        model.addAttribute("endDates", taskEndDateService.getAll());
        model.addAttribute("taskStates", taskTaskStateService.getAll());
        return "/mis/taskAdd";
    }

    @RequestMapping("/mis/task/add")
    public String add(Task task) {
        task.setState(ConstantCfg.ORDER_STATE_INITIAL);
        task.setCreator(0);
        task.setCreateTime(new Date());
        taskService.save(task);
        return "redirect:/mis/task";
    }

    @RequestMapping("/mis/task/toModify")
    public String toModify(Model model, Long id) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        model.addAttribute("types", taskTypeService.getAll());
        model.addAttribute("taskPeriods", taskTaskPeriodService.getAll());
        model.addAttribute("endDates", taskEndDateService.getAll());
        model.addAttribute("taskStates", taskTaskStateService.getAll());
        return "/mis/taskAdd";
    }

    @RequestMapping("/mis/task/modify")
    public String modify(Task task, Long id) {
        Task oldTask = taskService.getTaskById(id);
        oldTask.setTaskName(task.getTaskName());
        oldTask.setType(task.getType());
        oldTask.setTaskDesc(task.getTaskDesc());
        oldTask.setTaskPeriod(task.getTaskPeriod());
        oldTask.setBeginDate(task.getBeginDate());
        oldTask.setEndDate(task.getEndDate());
        oldTask.setEmployeeId(task.getEmployeeId());
        oldTask.setAmount(task.getAmount());
        oldTask.setTaskState(task.getTaskState());
        oldTask.setCompleteAmount(task.getCompleteAmount());
        oldTask.setUpdator(0);
        oldTask.setUpdateTime(new Date());
        taskService.merge(oldTask);
        return "redirect:/mis/task/toModify?id=" + id;
    }

    @RequestMapping("/mis/task/delete")
    public String delete(Long id) {
        Task oldTask = taskService.getTaskById(id);
        oldTask.setState(100);
        oldTask.setUpdator(0);
        oldTask.setUpdateTime(new Date());
        taskService.merge(oldTask);
        return "redirect:/mis/task";
    }
}