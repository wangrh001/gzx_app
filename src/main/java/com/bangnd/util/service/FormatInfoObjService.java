package com.bangnd.util.service;

import com.bangnd.util.entity.FormatInfoObject;

public interface FormatInfoObjService {
    public void save(long orderId,FormatInfoObject formatInfoObject,long opeator);
    public FormatInfoObject getFormatInfoObjByOrderId(long orderId);
    public void delete(long orderId);
    public void saveFormatInfo(String jsonStr,long orderId,int type);
}
