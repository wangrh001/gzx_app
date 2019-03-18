package com.bangnd.hr.web;

import com.bangnd.hr.entity.Curriculum;
import com.bangnd.hr.form.CurriculumSearchForm;
import com.bangnd.hr.service.CurriculumPosIdService;
import com.bangnd.hr.service.CurriculumService;
import com.bangnd.hr.service.CurriculumTypeService;
import com.bangnd.hr.vo.CurriculumVO;
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
public class CurriculumController {
    @Resource
    private CurriculumService curriculumService;
    @Resource
    CurriculumTypeService curriculumTypeService;
    @Resource
    CurriculumPosIdService curriculumPosIdService;

    @RequestMapping("/hr/curriculum")
    public String home(Model model, @RequestParam(value="pageNum",required=false) String pageNum, CurriculumSearchForm curriculumSearchForm) {
        if(pageNum==null){
            pageNum="1";
        }
        Page<Curriculum> pages =  curriculumService.getCurriculumList(Integer.valueOf(pageNum),ConstantCfg.NUM_PER_PAGE,curriculumSearchForm);
        model.addAttribute("types", curriculumTypeService.getAll());
        model.addAttribute("posIds", curriculumPosIdService.getAll());
        List<CurriculumVO> curriculumVOs = new ArrayList<>();
        if (pages != null) {
            for (Curriculum curriculum : pages) {
                CurriculumVO curriculumVO = new CurriculumVO();
                curriculumVO.setId(curriculum.getId());
                curriculumVO.setName(curriculum.getName());
                curriculumVO.setTypeName((curriculumTypeService.getCurriculumTypeById(curriculum.getType())).getName());
                curriculumVO.setTeacherName(curriculum.getTeacherName());
                curriculumVO.setPosIdName((curriculumPosIdService.getCurriculumPosIdById(curriculum.getPosId())).getName());
                curriculumVOs.add(curriculumVO);
            }
        }

        int pagenum=Integer.valueOf(pageNum);
        model.addAttribute("page",pages);
        model.addAttribute("pageNum",pagenum);
        model.addAttribute("totalPages",pages.getTotalPages());
        System.out.println("totalPages="+pages.getTotalPages());
        model.addAttribute("totalElements",pages.getTotalElements());
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