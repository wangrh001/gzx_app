package com.bangnd.sales.service;

import com.bangnd.sales.entity.PerformanceCommDetail;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface PerformanceCommDetailService {
    public void save(PerformanceCommDetail performanceCommDetail);

    public PerformanceCommDetail getPerformanceCommDetail(long orderId, long salerId);

    public void reCalc(long orderId);

    public void reCalcManagerComm(long employeeId);

    public List<PerformanceCommDetail> findAllByAgentId(long agentId, Date sd,Date ed);

    public BigDecimal findByOneDayAndAgentId(long agentId, String xdate) throws Exception;

}
