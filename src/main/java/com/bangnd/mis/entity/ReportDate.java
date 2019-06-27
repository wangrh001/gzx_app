package com.bangnd.mis.entity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ReportDate {
    //数据序列
    private List<String> series;
    //各个序列的x坐标都是一样的
    private List<String> xList;
    //每个序列，x坐标的List
    private Map<String, List<BigDecimal>> yMap;

    public List<String> getSeries() {
        return series;
    }

    public void setSeries(List<String> series) {
        this.series = series;
    }

    public List<String> getxList() {
        return xList;
    }

    public void setxList(List<String> xList) {
        this.xList = xList;
    }

    public Map<String, List<BigDecimal>> getyMap() {
        return yMap;
    }

    public void setyMap(Map<String, List<BigDecimal>> yMap) {
        this.yMap = yMap;
    }
}
