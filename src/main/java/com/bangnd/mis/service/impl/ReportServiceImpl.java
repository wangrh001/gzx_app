package com.bangnd.mis.service.impl;

import com.bangnd.finance.service.PaymentService;
import com.bangnd.mis.entity.ReportDate;
import com.bangnd.mis.service.ReportService;
import com.bangnd.sales.entity.Agent;
import com.bangnd.sales.entity.Group;
import com.bangnd.sales.service.AgentService;
import com.bangnd.sales.service.GroupService;
import com.bangnd.sales.service.PerformanceCommDetailService;
import com.bangnd.util.date.DateUtil;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    GroupService groupService;
    @Autowired
    AgentService agentService;
    @Autowired
    PerformanceCommDetailService pcs;
    @Autowired
    PaymentService paymentService;

    @Override
    public ReportDate getBusiReportDate(String startDate, String endDate) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date sd = simpleDateFormat.parse(startDate);
        Date ed = simpleDateFormat.parse(endDate);

        ReportDate reportDate = new ReportDate();
        List<String> series = new ArrayList<>();
        Map<String, List<BigDecimal>> yMap = new HashMap<>();
        List<String> xList = DateUtil.getWorkDateList(sd, ed);
        System.out.println("xList=" + xList.toString());
        reportDate.setxList(xList);

        List<Group> groupList = groupService.getAll();
        if (groupList != null && groupList.size() > 0) {
            for (Group group : groupList) {
                List<BigDecimal> yList = new ArrayList<>();
                series.add(group.getName().trim());
                if (xList != null && xList.size() > 0) {
                    for (String xdate : xList) {
                        BigDecimal groupPerformance = new BigDecimal(0.0);
                        List<Agent> agents = agentService.getAgentByGroupId(group.getId());
                        if (agents != null && agents.size() > 0) {
                            for (Agent agent : agents) {
                                groupPerformance = groupPerformance.add(pcs.findByOneDayAndAgentId(agent.getId(), xdate));
                            }
                        }
                        yList.add(groupPerformance);
                    }
                }
                yMap.put(group.getName(), yList);
            }
        }
        reportDate.setSeries(series);
        reportDate.setyMap(yMap);
        return reportDate;
    }

    @Override
    public ReportDate getFinBalanceReportDate(String startDate, String endDate) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date sd = simpleDateFormat.parse(startDate);
        Date ed = simpleDateFormat.parse(endDate);
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(ed);
//        calendar.add(Calendar.DAY_OF_YEAR,1);
//        ed = calendar.getTime();

        ReportDate reportDate = new ReportDate();
        List<String> series = new ArrayList<>();
        Map<String, List<String>> xMap = new HashMap<>();
        Map<String, List<BigDecimal>> yMap = new HashMap<>();
        List<String> xList = DateUtil.getWorkDateList(sd, ed);

        //每个序列一个yList
        series.add("收入");
        List<BigDecimal> yList1 = new ArrayList<>();
        series.add("支出");
        List<BigDecimal> yList2 = new ArrayList<>();
        series.add("利润");
        List<BigDecimal> yList3 = new ArrayList<>();
        reportDate.setSeries(series);
        reportDate.setxList(xList);
        if (xList != null && xList.size() > 0) {
            for (String xdate : xList) {
                Date date = simpleDateFormat.parse(xdate);
                BigDecimal income = paymentService.getSumIncome(date);
                yList1.add(income);
                BigDecimal expend = paymentService.getSumExpend(date);
                yList2.add(expend);
                BigDecimal profit = income.subtract(expend);
                yList3.add(profit);
                BigDecimal cashIn = paymentService.getSumCashIn(date);
            }
            yMap.put("收入", yList1);
            yMap.put("支出", yList2);
            yMap.put("利润", yList3);
            reportDate.setyMap(yMap);
        }
        return reportDate;
    }

    @Override
    public ReportDate getFinCashFlowReportDate(String startDate, String endDate) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date sd = simpleDateFormat.parse(startDate);
        Date ed = simpleDateFormat.parse(endDate);
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(ed);
//        calendar.add(Calendar.DAY_OF_YEAR,1);
//        ed = calendar.getTime();

        ReportDate reportDate = new ReportDate();
        List<String> series = new ArrayList<>();
        Map<String, List<String>> xMap = new HashMap<>();
        Map<String, List<BigDecimal>> yMap = new HashMap<>();
        List<String> xList = DateUtil.getWorkDateList(sd, ed);

        //每个序列一个yList
        series.add("现金流入");
        List<BigDecimal> yList4 = new ArrayList<>();
        series.add("现金流出");
        List<BigDecimal> yList5 = new ArrayList<>();
        reportDate.setSeries(series);
        reportDate.setxList(xList);
        if (xList != null && xList.size() > 0) {
            for (String xdate : xList) {
                Date date = simpleDateFormat.parse(xdate);
                BigDecimal cashIn = paymentService.getSumCashIn(date);
                yList4.add(cashIn);
                BigDecimal cashOut = paymentService.getSumCashOut(date);
                yList5.add(cashOut);
            }
            yMap.put("现金流入", yList4);
            yMap.put("现金流出", yList5);
            reportDate.setyMap(yMap);
        }
        return reportDate;
    }

    @Override
    public String getSeriesJson(ReportDate reportDate) {
        String series = "";
        if (reportDate != null) {
            System.out.println(reportDate.getSeries().toString().replaceAll(" ", ""));
            series = reportDate.getSeries().toString().trim();
            return series.replaceAll("[\\[\\]]", "").replaceAll(" ", "");
        }
        return "";
    }

    @Override
    public String getXJson(ReportDate reportDate) {
        if (reportDate != null) {
            System.out.println(reportDate.getxList().toString().trim().replaceAll(" ", ""));
            return reportDate.getxList().toString().trim().replaceAll("[\\[\\]]", "").replaceAll(" ", "");
        }
        return "";
    }

    @Override
    public String getYJson(ReportDate reportDate) throws Exception {
        List jsonList = new ArrayList<>();
        if (reportDate != null) {
            Map<String, List<BigDecimal>> yMap = new HashMap<>();
            yMap = reportDate.getyMap();
            if (yMap != null && yMap.size() > 0) {
                int i = 1;
                for (Map.Entry<String, List<BigDecimal>> entry : yMap.entrySet()) {
                    JSONObject js = new JSONObject();
                    js.put("name", entry.getKey());
                    js.put("type", "line");
                    js.put("smooth", "true");
                    js.put("data", entry.getValue());
                    jsonList.add(js);
                }
            }
        }
        System.out.println(jsonList.toString());
        return jsonList.toString();
    }

    public static void main(String[] args) {
        List<String> series = new ArrayList<>();
        series.add("收入");
        series.add("支出");
        series.add("利润");
        series.add("现金流入");
        series.add("现金流出");
        System.out.println(series.toString());
    }

}
