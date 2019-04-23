package com.bangnd.cbs.service.impl;

import com.bangnd.cbs.entity.OrderLog;
import com.bangnd.cbs.repository.OrderLogRepository;
import com.bangnd.cbs.service.OrderLogService;
import com.bangnd.util.entity.FormatInfo;
import com.bangnd.util.entity.FormatInfoObject;
import com.bangnd.util.service.FormatInfoService;
import com.dashu.AutoBulider.config.ConstantCfg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderLogServiceImpl implements OrderLogService {
    @Autowired
    OrderLogRepository orderLogRepository;
    @Autowired
    FormatInfoService formatInfoService;

    @Override
    public void save(OrderLog orderLog) {
        orderLogRepository.save(orderLog);
    }

    @Override
    public Page<OrderLog> getAllLogByOrderId(Integer pageNum, int size, long orderId) {
        Specification specification = new Specification<OrderLog>() {
            @Override
            public Predicate toPredicate(Root<OrderLog> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<Predicate>();
                predicates.add(cb.equal(root.get("orderId").as(Long.class), orderId));
                Predicate[] p = new Predicate[predicates.size()];
                return cb.and(predicates.toArray(p));
            }
        };
        Sort sort = new Sort(Sort.Direction.ASC, "operatorTime");
        Pageable pageable = new PageRequest((pageNum - 1), size, sort);
        Page<OrderLog> qyPage = this.orderLogRepository.findAll(specification, pageable);
        return qyPage;
    }

    @Override
    public boolean isHandleOrder(long orderId, long userId) {
        List<OrderLog> orderLogs = orderLogRepository.findAllByOrderIdAndUserId(orderId, userId);
        if (orderLogs != null) {
            return true;
        } else return false;
    }

    @Override
    public void recordLog(long orderId, long userId, int buttonId,FormatInfoObject formatInfoObject) {
        //先保存按钮产生的操作时间
        recordLog(orderId,userId,buttonId);

        //再保存填写的时间
        if(formatInfoObject!=null){
            List<FormatInfo> formatInfos = formatInfoService.getAllByDataType(ConstantCfg.COLUMN_TYPE_DATE);
            for(FormatInfo formatInfo:formatInfos){
                try {
                    Method method = formatInfoObject.getClass().getMethod("get"+Character.toUpperCase(formatInfo.getEnName().charAt(0))+formatInfo.getEnName().substring(1));
                    //先判断传入的对象有该日期的值
                    if(method.invoke(formatInfoObject)!=null){
                        Date value=(Date)method.invoke(formatInfoObject);
                        OrderLog orderLog = orderLogRepository.findByOrderIdAndFormatInfoId(orderId,formatInfo.getId());
                        //再判断是不是已经存储过了，如果已经存储过了，就进行更新
                        if(orderLog==null){
                            OrderLog orderLog1 = new OrderLog();
                            orderLog1.setOrderId(orderId);
                            orderLog1.setUserId(userId);
                            orderLog1.setFormatInfoId(formatInfo.getId());
                            orderLog1.setState(1);
                            orderLog1.setOperatorTime(value);
                            orderLog1.setCreator(Long.valueOf(userId).intValue());
                            orderLog1.setCreateTime(new Date());
                            orderLogRepository.save(orderLog1);
                        }else {
                            orderLog.setOperatorTime(value);
                            orderLog.setUpdator(Long.valueOf(userId).intValue());
                            orderLog.setUpdateTime(new Date());
                            orderLogRepository.saveAndFlush(orderLog);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void recordLog(long orderId, long userId, int buttonId) {
        OrderLog orderLog = new OrderLog();
        orderLog.setOrderId(orderId);
        orderLog.setUserId(userId);
        orderLog.setButtonId(buttonId);
        orderLog.setFormatInfoId(0);
        orderLog.setState(1);
        orderLog.setOperatorTime(new Date());
        orderLog.setCreator(Long.valueOf(userId).intValue());
        orderLog.setCreateTime(new Date());
        orderLogRepository.save(orderLog);
    }
}
