package com.bangnd.mis.service;

import com.bangnd.mis.entity.ReportDate;
import org.codehaus.jettison.json.JSONObject;

import java.util.List;

public interface ReportService {
    public ReportDate getBusiReportDate(String startDate,String endDate) throws Exception;
    public ReportDate getFinBalanceReportDate(String startDate,String endDate) throws Exception;
    public ReportDate getFinCashFlowReportDate(String startDate,String endDate) throws Exception;
    public String getSeriesJson(ReportDate reportDate);
    public String getXJson(ReportDate reportDate);
    public String getYJson(ReportDate reportDate) throws Exception;
}
