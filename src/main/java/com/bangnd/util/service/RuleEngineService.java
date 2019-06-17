package com.bangnd.util.service;

import java.math.BigDecimal;

public interface RuleEngineService {
    /**
     * 给订单id，计算该订单的收入
     *
     * @param orderId,type
     */
    public BigDecimal calc(long orderId, int type);

    public boolean workFlowCondition(long orderId, String condition) throws Exception;
}
