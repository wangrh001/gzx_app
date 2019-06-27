package com.bangnd.cbs.service;

import com.bangnd.bridgecbs.entity.BridgeOrder;
import com.bangnd.cbs.entity.OrderPool;

public interface BusinessReminderService {

    public void remindNextOperator(long userId,int buttonId,OrderPool orderPool,String actionName,String loanName) throws Exception ;
    public void informRelativePerson(int buttonId, BridgeOrder bridgeOrder,String logDesc) throws Exception ;
}
