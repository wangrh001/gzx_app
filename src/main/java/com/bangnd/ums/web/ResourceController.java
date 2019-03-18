package com.bangnd.ums.web;

import com.bangnd.ums.form.ResourceSearchForm;
import com.bangnd.ums.service.ResourceService;
import com.bangnd.ums.service.ResourceTypeService;
import com.bangnd.ums.vo.ResourceVO;
import com.bangnd.util.cfg.ConstantCfg;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ResourceController {
    @Resource
    private ResourceService resourceService;
    @Resource
    ResourceTypeService resourceTypeService;
    //必须是：required=false
    @RequestMapping("/ums/resource")
    public String home(Model model,@RequestParam(value="pageNum",required=false) String pageNum, ResourceSearchForm resourceSearchForm) {
//        List<com.bangnd.ums.entity.Resource> resources = resourceService.getResourceList(resourceSearchForm);
        if(pageNum==null){
            pageNum="1";
        }
        System.out.println("pageNum="+pageNum);
        Page<com.bangnd.ums.entity.Resource> pages=resourceService.getResourceList(Integer.valueOf(pageNum),ConstantCfg.NUM_PER_PAGE,resourceSearchForm);
        model.addAttribute("types", resourceTypeService.getAll());
        model.addAttribute("parentIds", resourceService.getAll());
        List<ResourceVO> resourceVOs = new ArrayList<>();
        if (pages != null) {
            for (com.bangnd.ums.entity.Resource resource : pages) {
                ResourceVO resourceVO = new ResourceVO();
                resourceVO.setId(resource.getId());
                resourceVO.setName(resource.getName());
                resourceVO.setResUrl(resource.getResUrl());
                resourceVO.setColumnName(resource.getColumnName());
                resourceVO.setValueSet(resource.getValueSet());
                resourceVO.setTypeName((resourceTypeService.getResourceTypeById(resource.getType())).getName());
                resourceVO.setParentIdName((resourceService.getResourceById(resource.getParentId())).getName());
                resourceVOs.add(resourceVO);
            }
        }
        int pagenum=Integer.valueOf(pageNum);
        model.addAttribute("page",pages);
        model.addAttribute("pageNum",pagenum);
        model.addAttribute("totalPages",pages.getTotalPages());
        System.out.println("totalPages="+pages.getTotalPages());
        model.addAttribute("totalElements",pages.getTotalElements());

        model.addAttribute("resourceVOs", resourceVOs);
        return "/ums/resourceList";
    }

    @RequestMapping("/ums/resource/toAdd")
    public String toAdd(Model model) {
        com.bangnd.ums.entity.Resource resource = new com.bangnd.ums.entity.Resource();
        model.addAttribute("resource", resource);
        model.addAttribute("types", resourceTypeService.getAll());
        model.addAttribute("parentIds", resourceService.getAll());
        return "/ums/resourceAdd";
    }

    @RequestMapping("/ums/resource/add")
    public String add(com.bangnd.ums.entity.Resource resource) {
        resource.setState(ConstantCfg.ORDER_STATE_INITIAL);
        resource.setCreator(0);
        resource.setCreateTime(new Date());
        resourceService.save(resource);
        return "redirect:/ums/resource";
    }

    @RequestMapping("/ums/resource/toModify")
    public String toModify(Model model, Long id) {
        com.bangnd.ums.entity.Resource resource = resourceService.getResourceById(id);
        model.addAttribute("resource", resource);
        model.addAttribute("types", resourceTypeService.getAll());
        model.addAttribute("parentIds", resourceService.getAll());
        return "/ums/resourceAdd";
    }

    @RequestMapping("/ums/resource/modify")
    public String modify(com.bangnd.ums.entity.Resource resource, Long id) {
        com.bangnd.ums.entity.Resource oldResource = resourceService.getResourceById(id);
        oldResource.setName(resource.getName());
        oldResource.setResUrl(resource.getResUrl());
        oldResource.setType(resource.getType());
        oldResource.setParentId(resource.getParentId());
        oldResource.setUpdator(0);
        oldResource.setUpdateTime(new Date());
        resourceService.merge(oldResource);
        return "redirect:/ums/resource/toModify?id=" + id;
    }

    @RequestMapping("/ums/resource/delete")
    public String delete(Long id) {
        com.bangnd.ums.entity.Resource oldResource = resourceService.getResourceById(id);
        oldResource.setState(100);
        oldResource.setUpdator(0);
        oldResource.setUpdateTime(new Date());
        resourceService.merge(oldResource);
        return "redirect:/ums/resource";
    }

    @RequestMapping("/index")
    public String getMenuTree(Model model, HttpSession session) {
        List<com.bangnd.ums.entity.Resource> resources =(List<com.bangnd.ums.entity.Resource>) session.getAttribute("userRes");
        String menuTree = resourceService.getMenuTreeString(resources);
        model.addAttribute("menus", menuTree);
        return "/index";
    }
}