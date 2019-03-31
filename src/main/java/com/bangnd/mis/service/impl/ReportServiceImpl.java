package com.bangnd.mis.service.impl;

import com.bangnd.cbs.service.impl.B;
import com.bangnd.finance.service.PaymentService;
import com.bangnd.mis.entity.ReportDate;
import com.bangnd.mis.service.ReportService;
import com.bangnd.sales.entity.Agent;
import com.bangnd.sales.entity.Group;
import com.bangnd.sales.entity.PerformanceCommDetail;
import com.bangnd.sales.service.AgentService;
import com.bangnd.sales.service.GroupService;
import com.bangnd.sales.service.PerformanceCommDetailService;
import com.bangnd.util.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public ReportDate getBusiReportDate(String startDate, String endDate) throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date sd = simpleDateFormat.parse(startDate);
        Date ed = simpleDateFormat.parse(endDate);

        ReportDate reportDate = new ReportDate();
        List<String> series = new ArrayList<>();
        Map<String,List<BigDecimal>> yMap = new HashMap<>();
        List<String> xList= DateUtil.getWorkDateList(sd,ed);
        reportDate.setxList(xList);

        List<Group> groupList = groupService.getAll();
        BigDecimal agentPerformance= new BigDecimal(0.0);
        BigDecimal groupPerformance= new BigDecimal(0.0);
        if(groupList!=null && groupList.size()>0){
            List<BigDecimal> yList=new ArrayList<>();
            for(Group group:groupList){
                series.add(group.getName());
                if(xList!=null && xList.size()>0){
                    for(String xdate:xList){
                        List<Agent> agents = agentService.getAgentByGroupId(group.getId());
                        if(agents!=null&&agents.size()>0){
                            for (Agent agent:agents){
                                List<PerformanceCommDetail> pcds=pcs.findByOneDayAndAgentId(agent.getId(),xdate);
                                if(pcds!=null && pcds.size()>0){
                                    for(PerformanceCommDetail pc:pcds){
                                        agentPerformance=agentPerformance.add(pc.getPerformance());
                                    }
                                }
                            }
                        }
                        groupPerformance=groupPerformance.add(agentPerformance);
                    }
                    yList.add(groupPerformance);
                }
                yMap.put(group.getName(),yList);
            }
        }
        reportDate.setSeries(series);
        reportDate.setyMap(yMap);
        return reportDate;
    }

    @Override
    public ReportDate getFinReportDate(String startDate, String endDate) throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date sd = simpleDateFormat.parse(startDate);
        Date ed = simpleDateFormat.parse(endDate);

        ReportDate reportDate = new ReportDate();
        List<String> series = new ArrayList<>();
        Map<String,List<String>> xMap = new HashMap<>();
        Map<String,List<BigDecimal>> yMap = new HashMap<>();
        List<String> xList= DateUtil.getWorkDateList(sd,ed);

        //每个序列一个yList
        series.add("收入");
        List<BigDecimal> yList1=new ArrayList<>();
        series.add("支出");
        List<BigDecimal> yList2=new ArrayList<>();
        series.add("利润");
        List<BigDecimal> yList3=new ArrayList<>();
        series.add("现金流入");
        List<BigDecimal> yList4=new ArrayList<>();
        series.add("现金流出");
        List<BigDecimal> yList5=new ArrayList<>();
        reportDate.setSeries(series);
        reportDate.setxList(xList);
        if(xList!=null&&xList.size()>0){
            for(String xdate:xList){
                Date date = simpleDateFormat.parse(xdate);
                BigDecimal income = paymentService.getSumIncome(date);
                yList1.add(income);
                BigDecimal expend = paymentService.getSumExpend(date);
                yList2.add(expend);
                BigDecimal profit = income.subtract(expend);
                yList3.add(profit);
                BigDecimal cashIn = paymentService.getSumCashIn(date);
                yList4.add(cashIn);
                BigDecimal cashOut = paymentService.getSumCashOut(date);
                yList5.add(cashOut);

            }
        }
        return reportDate;
    }

    @Override
    public String getSeriesJson(ReportDate reportDate) {
        if(reportDate!=null){
            return reportDate.getSeries().toString();
        }
        return "";
    }

    @Override
    public String getXJson(ReportDate reportDate) {
        if(reportDate!=null) {
            return reportDate.getxList().toString();
        }
        return "";
    }

    @Override
    public String getYJson(ReportDate reportDate) {
        String json = "";
        if(reportDate!=null){
            Map<String,List<BigDecimal>> yMap = new HashMap<>();
            yMap=reportDate.getyMap();
            if(yMap!=null&&yMap.size()>0){
                int i=1;
                for(Map.Entry<String,List<BigDecimal>> entry:yMap.entrySet()){
                    String series = entry.getKey();
                    List<BigDecimal> yList = entry.getValue();
                    if(i<yMap.size()){
                        json="[{name="+series+",type:'line',smooth: true,data:"+yList.toString()+"},";
                    }else if(i==yMap.size()){
                        json="[{name="+series+",type:'line',smooth: true,data:"+yList.toString()+"}]";
                    }
                    i++;
                }
            }
        }
        return json;
    }

    public static void main(String[] args){
        List<String> series = new ArrayList<>();
        series.add("收入");
        series.add("支出");
        series.add("利润");
        series.add("现金流入");
        series.add("现金流出");
        System.out.println(series.toString());
    }

}
