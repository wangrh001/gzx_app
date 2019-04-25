package com.bangnd.cbs.service;

import com.bangnd.cbs.entity.OrderPool;

public interface BusinessReminderService {

    public void remindNextOperator(long userId,int buttonId,OrderPool orderPool,String actionName) throws Exception ;
}
