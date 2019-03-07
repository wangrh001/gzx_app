package com.bangnd.hr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import org.springframework.ui.Model;

import java.util.*;

import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.hr.web.*;
import com.bangnd.hr.entity.*;
import com.bangnd.hr.form.*;
import com.bangnd.hr.service.*;
import com.bangnd.hr.service.impl.*;
import com.bangnd.hr.vo.*;

@Controller
public class CurriculumController {
    @Resource
    private CurriculumService curriculumService;
    @Resource
    CurriculumTypeService curriculumTypeService;
    @Resource
    CurriculumPosIdService curriculumPosIdService;

    @RequestMapping("/hr/curriculum")
    public String home(Model model, CurriculumSearchForm curriculumSearchForm) {
        List<Curriculum> curriculums = curriculumService.getCurriculumList(curriculumSearchForm);
        model.addAttribute("types", curriculumTypeService.getAll());
        model.addAttribute("posIds", curriculumPosIdService.getAll());
        List<CurriculumVO> curriculumVOs = new ArrayList<>();
        if (curriculums != null) {
            for (Curriculum curriculum : curriculums) {
                CurriculumVO curriculumVO = new CurriculumVO();
                curriculumVO.setId(curriculum.getId());
                curriculumVO.setName(curriculum.getName());
                curriculumVO.setTypeName((curriculumTypeService.getCurriculumTypeById(curriculum.getType())).getName());
                curriculumVO.setTeacherName(curriculum.getTeacherName());
                curriculumVO.setPosIdName((curriculumPosIdService.getCurriculumPosIdById(curriculum.getPosId())).getName());
                curriculumVOs.add(curriculumVO);
            }
        }
        model.addAttribute("curriculumVOs", curriculumVOs);
        return "/hr/curriculumList";
    }

    @RequestMapping("/hr/curriculum/toAdd")
    public String toAdd(Model model) {
        Curriculum curriculum = new Curriculum();
        model.addAttribute("curriculum", curriculum);
        model.addAttribute("types", curriculumTypeService.getAll());
        model.addAttribute("posIds", curriculumPosIdService.getAll());
        return "/hr/curriculumAdd";
    }

    @RequestMapping("/hr/curriculum/add")
    public String add(Curriculum curriculum) {
        curriculum.setState(ConstantCfg.ORDER_STATE_INITIAL);
        curriculum.setCreator(0);
        curriculum.setCreateTime(new Date());
        curriculumService.save(curriculum);
        return "redirect:/hr/curriculum";
    }

    @RequestMapping("/hr/curriculum/toModify")
    public String toModify(Model model, Long id) {
        Curriculum curriculum = curriculumService.getCurriculumById(id);
        model.addAttribute("curriculum", curriculum);
        model.addAttribute("types", curriculumTypeService.getAll());
        model.addAttribute("posIds", curriculumPosIdService.getAll());
        return "/hr/curriculumAdd";
    }

    @RequestMapping("/hr/curriculum/modify")
    public String modify(Curriculum curriculum, Long id) {
        Curriculum oldCurriculum = curriculumService.getCurriculumById(id);
        oldCurriculum.setName(curriculum.getName());
        oldCurriculum.setType(curriculum.getType());
        oldCurriculum.setTeacherName(curriculum.getTeacherName());
        oldCurriculum.setPosId(curriculum.getPosId());
        oldCurriculum.setUpdator(0);
        oldCurriculum.setUpdateTime(new Date());
        curriculumService.merge(oldCurriculum);
        return "redirect:/hr/curriculum/toModify?id=" + id;
    }

    @RequestMapping("/hr/curriculum/delete")
    public String delete(Long id) {
        Curriculum oldCurriculum = curriculumService.getCurriculumById(id);
        oldCurriculum.setState(100);
        oldCurriculum.setUpdator(0);
        oldCurriculum.setUpdateTime(new Date());
        curriculumService.merge(oldCurriculum);
        return "redirect:/hr/curriculum";
    }
}