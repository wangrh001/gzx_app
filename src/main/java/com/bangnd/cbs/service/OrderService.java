package com.bangnd.cbs.service;

import com.bangnd.cbs.entity.Order;
import com.bangnd.cbs.form.OrderSearchForm;
import com.dingtalk.api.response.OapiProcessinstanceGetResponse;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface OrderService {
    public void save(Order order);

    public Page<Order> getOrderList(Integer pageNum, int size, List<Long> orderList, OrderSearchForm orderSearchForm);

    public Page<Order> getAllOrderList(Integer pageNum, int size, OrderSearchForm orderSearchForm);

    public List<Order> findOrderBySalesId(long salesId, Date startDate, Date endDate);

    public Order findOrderById(long ind);

    public void delete(Long id);

    public void flush(Order order);

    public void saveClientApprove(String approveId, OapiProcessinstanceGetResponse response) throws Exception;

    public void halderFeeByDiffStep(int afterState,Order order,long updatorId,BigDecimal selfAmount);

    public List<Order> getNotFinishOrders();
}
