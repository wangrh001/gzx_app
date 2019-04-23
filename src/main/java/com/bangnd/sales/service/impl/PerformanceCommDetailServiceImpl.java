package com.bangnd.sales.service.impl;

import com.bangnd.cbs.entity.Order;
import com.bangnd.cbs.service.OrderService;
import com.bangnd.sales.entity.PerformanceCommDetail;
import com.bangnd.sales.repository.PerformanceCommDetailRepository;
import com.bangnd.sales.service.PerformanceCommDetailService;
import com.bangnd.util.cfg.ConstantCfg;
import com.bangnd.util.date.DateUtil;
import com.bangnd.util.service.RuleEngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class PerformanceCommDetailServiceImpl implements PerformanceCommDetailService {
    @Autowired
    OrderService orderService;
    @Autowired
    RuleEngineService ruleEngineService;

    @Autowired
    PerformanceCommDetailRepository performanceCommDetailRepository;
    @Autowired
    PerformanceCommDetailService performanceCommDetailService;

    @Override
    public void save(PerformanceCommDetail performanceCommDetail) {
        performanceCommDetailRepository.save(performanceCommDetail);
    }

    @Override
    public PerformanceCommDetail getPerformanceCommDetail(long orderId, long salerId) {
        PerformanceCommDetail performanceCommDetail = null;
        try {
            performanceCommDetail = performanceCommDetailRepository.findPerformanceCommDetailByOrderId(orderId, salerId);
            return performanceCommDetail;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void reCalc(long orderId) {
        Order order = orderService.findOrderById(orderId);
        Date startDate = DateUtil.getMonthStart(order.getSignDate());
        Date endDate = DateUtil.getMonthEnd(order.getSignDate());
        List<Order> orders = orderService.findOrderBySalesId(order.getSalerId(), startDate, endDate);
        if (orders != null && orders.size() > 0) {
            for (Order order1 : orders) {
                BigDecimal commission = ruleEngineService.calc(order1.getId(), ConstantCfg.CALC_TYPE_5);
                PerformanceCommDetail performanceCommDetail = performanceCommDetailRepository.findPerformanceCommDetailByOrderId(order1.getSalerId(), order1.getId());
                if (performanceCommDetail != null && performanceCommDetail.getId() != 0) {
                    performanceCommDetail.setCommission(commission);
                    performanceCommDetail.setUpdateTime(new Date());
                    performanceCommDetailRepository.save(performanceCommDetail);
                }
            }

        }


    }

    @Override
    public void reCalcManagerComm(long employeeId) {

    }

    @Override
    public List<PerformanceCommDetail> findAllByAgentId(long agentId,Date sd, Date ed) {
        return performanceCommDetailRepository.findAllByAgentId(agentId,sd,ed);
    }

    @Override
    public BigDecimal findByOneDayAndAgentId(long agentId, String xdate) throws Exception{
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date sd = sdf.parse(xdate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sd);
        calendar.add(Calendar.DAY_OF_YEAR,1);
        Date ed = calendar.getTime();
        System.out.println("agent_id = "+agentId);
        System.out.println("sd = "+sd);
        System.out.println("ed = "+ed);
        BigDecimal sumPerformance = performanceCommDetailRepository.findAllByAgentIdAndCreateTime(agentId,sd,ed);
        if(sumPerformance==null){
            sumPerformance=new BigDecimal(0.0);
        }
        System.out.println("sumPerformance="+sumPerformance);
        return sumPerformance;
    }
}
