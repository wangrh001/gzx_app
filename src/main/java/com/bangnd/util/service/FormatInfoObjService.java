package com.bangnd.util.service;

import com.bangnd.util.entity.FormatInfoObject;

import java.util.Date;

public interface FormatInfoObjService {
    public FormatInfoObject save(long orderId, FormatInfoObject formatInfoObject, long opeator);

    public FormatInfoObject getFormatInfoObjByOrderId(long orderId);

    public void delete(long orderId);

    public void saveFormatInfo(String jsonStr, long orderId, int type);

    public Date getSignDate(long orderId);
}
