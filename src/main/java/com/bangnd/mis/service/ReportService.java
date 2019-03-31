package com.bangnd.mis.service;

import com.bangnd.mis.entity.ReportDate;

public interface ReportService {
    public ReportDate getBusiReportDate(String startDate,String endDate) throws Exception;
    public ReportDate getFinReportDate(String startDate,String endDate) throws Exception;
    public String getSeriesJson(ReportDate reportDate);
    public String getXJson(ReportDate reportDate);
    public String getYJson(ReportDate reportDate);
}
