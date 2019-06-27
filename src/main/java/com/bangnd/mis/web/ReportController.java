package com.bangnd.mis.web;

import com.bangnd.mis.entity.Period;
import com.bangnd.mis.entity.ReportDate;
import com.bangnd.mis.service.PeriodService;
import com.bangnd.mis.service.ReportService;
import com.bangnd.util.date.DateUtil;
import com.bangnd.util.entity.PeriodType;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Controller
public class ReportController {

    @Resource
    PeriodService periodService;
    @Resource
    ReportService reportService;

    @RequestMapping("/mis/showBusiReport")
    public String showBusiReport(Model model, Integer periodId) throws Exception {
        System.out.println("periodId=" + periodId);
        String startDate = DateUtil.getStartDateByPeriodType(periodId);
        String endDate = DateUtil.getEndDateByPeriodType(periodId);

        ReportDate reportDate = reportService.getBusiReportDate(startDate, endDate);
        String seriesJson = reportService.getSeriesJson(reportDate);
        String xJson = reportService.getXJson(reportDate);
        String yJson = reportService.getYJson(reportDate);
        List<Period> periods = periodService.getAll();
        Period period = new Period();

        model.addAttribute("periodId", xJson);
        model.addAttribute("seriesJson", seriesJson);
        model.addAttribute("xJson", xJson);
        model.addAttribute("yJson", yJson);
        model.addAttribute("period", period);
        model.addAttribute("periods", periods);
        return "/mis/businessReport";
    }

    @RequestMapping("/mis/showFinReport")
    public String showFinReport(Model model, Integer periodId) throws Exception {
        String startDate = DateUtil.getStartDateByPeriodType(periodId);
        String endDate = DateUtil.getEndDateByPeriodType(periodId);

        ReportDate reportDateBalance = reportService.getFinBalanceReportDate(startDate, endDate);
        String seriesJsonBalance = reportService.getSeriesJson(reportDateBalance);
        String xJson = reportService.getXJson(reportDateBalance);
        String yJsonBalance = reportService.getYJson(reportDateBalance);

        model.addAttribute("xJson", xJson);
        model.addAttribute("seriesJsonBalance", seriesJsonBalance);
        model.addAttribute("yJsonBalance", yJsonBalance);
        List<Period> periods = periodService.getAll();
        Period period = new Period();
        model.addAttribute("period", period);
        model.addAttribute("periods", periods);
        return "/mis/financeReport";
    }

    @RequestMapping("/mis/cashFlowReport")
    public String cashFlowReport(Model model, Integer periodId) throws Exception {
        String startDate = DateUtil.getStartDateByPeriodType(periodId);
        String endDate = DateUtil.getEndDateByPeriodType(periodId);

        ReportDate reportDateCashFlow = reportService.getFinCashFlowReportDate(startDate, endDate);
        String seriesJsonCashFlow = reportService.getSeriesJson(reportDateCashFlow);
        String xJson = reportService.getXJson(reportDateCashFlow);
        String yJsonCashFlow = reportService.getYJson(reportDateCashFlow);

        model.addAttribute("seriesJsonCashFlow", seriesJsonCashFlow);
        model.addAttribute("yJsonCashFlow", yJsonCashFlow);

        List<Period> periods = periodService.getAll();
        Period period = new Period();
        model.addAttribute("xJson", xJson);
        model.addAttribute("period", period);
        model.addAttribute("periods", periods);
        return "/mis/cashFlowReport";
    }
}
