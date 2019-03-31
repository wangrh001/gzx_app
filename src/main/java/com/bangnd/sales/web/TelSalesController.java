package com.bangnd.sales.web;

import com.bangnd.sales.entity.TelSales;
import com.bangnd.sales.form.TelSalesSearchForm;
import com.bangnd.sales.service.TelSalesResultService;
import com.bangnd.sales.service.TelSalesService;
import com.bangnd.sales.service.TelSalesTaskDelayService;
import com.bangnd.sales.vo.TelSalesVO;
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
public class TelSalesController {
    @Resource
    private TelSalesService telSalesService;
    @Resource
    TelSalesResultService telSalesResultService;
    @Resource
    TelSalesTaskDelayService telSalesTaskDelayService;

    @RequestMapping("/sales/telSales")
    public String home(Model model, @RequestParam(value = "pageNum", required = false) String pageNum, TelSalesSearchForm telSalesSearchForm) {
        if (pageNum == null) {
            pageNum = "1";
        }
        Page<TelSales> pages = telSalesService.getTelSalesList(Integer.valueOf(pageNum), ConstantCfg.NUM_PER_PAGE, telSalesSearchForm);
        model.addAttribute("results", telSalesResultService.getAll());
        model.addAttribute("taskDelays", telSalesTaskDelayService.getAll());
        List<TelSalesVO> telSalesVOs = new ArrayList<>();
        if (pages != null) {
            for (TelSales telSales : pages) {
                TelSalesVO telSalesVO = new TelSalesVO();
                telSalesVO.setId(telSales.getId());
                telSalesVO.setPhone(telSales.getPhone());
                telSalesVOs.add(telSalesVO);
            }
        }

        int pagenum = Integer.valueOf(pageNum);
        model.addAttribute("page", pages);
        model.addAttribute("pageNum", pagenum);
        model.addAttribute("totalPages", pages.getTotalPages());
        System.out.println("totalPages=" + pages.getTotalPages());
        model.addAttribute("totalElements", pages.getTotalElements());
        model.addAttribute("telSalesVOs", telSalesVOs);
        return "/sales/telSalesList";
    }

    @RequestMapping("/sales/telSales/toAdd")
    public String toAdd(Model model) {
        TelSales telSales = new TelSales();
        model.addAttribute("telSales", telSales);
        model.addAttribute("results", telSalesResultService.getAll());
        model.addAttribute("taskDelays", telSalesTaskDelayService.getAll());
        return "/sales/telSalesAdd";
    }

    @RequestMapping("/sales/telSales/add")
    public String add(TelSales telSales) {
        telSales.setState(ConstantCfg.ORDER_STATE_INITIAL);
        telSales.setCreator(0);
        telSales.setCreateTime(new Date());
        telSalesService.save(telSales);
        return "redirect:/sales/telSales";
    }

    @RequestMapping("/sales/telSales/toModify")
    public String toModify(Model model, Long id) {
        TelSales telSales = telSalesService.getTelSalesById(id);
        model.addAttribute("telSales", telSales);
        model.addAttribute("results", telSalesResultService.getAll());
        model.addAttribute("taskDelays", telSalesTaskDelayService.getAll());
        return "/sales/telSalesAdd";
    }

    @RequestMapping("/sales/telSales/modify")
    public String modify(TelSales telSales, Long id) {
        TelSales oldTelSales = telSalesService.getTelSalesById(id);
        oldTelSales.setResult(telSales.getResult());
        oldTelSales.setTaskDelay(telSales.getTaskDelay());
        oldTelSales.setMarkDesc(telSales.getMarkDesc());
        oldTelSales.setHistDesc(telSales.getHistDesc());
        oldTelSales.setUpdator(0);
        oldTelSales.setUpdateTime(new Date());
        telSalesService.merge(oldTelSales);
        return "redirect:/sales/telSales/toModify?id=" + id;
    }

    @RequestMapping("/sales/telSales/delete")
    public String delete(Long id) {
        TelSales oldTelSales = telSalesService.getTelSalesById(id);
        oldTelSales.setState(100);
        oldTelSales.setUpdator(0);
        oldTelSales.setUpdateTime(new Date());
        telSalesService.merge(oldTelSales);
        return "redirect:/sales/telSales";
    }
}