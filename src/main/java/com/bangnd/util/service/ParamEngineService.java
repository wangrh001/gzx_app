package com.bangnd.util.service;

public interface ParamEngineService {
    /**
     * 根据参数名，找到获取这个参数的方法
     * @param param
     * @return
     */
    public String getMathodName(String param);
}
