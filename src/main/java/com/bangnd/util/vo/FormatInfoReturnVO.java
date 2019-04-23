package com.bangnd.util.vo;

public class FormatInfoReturnVO {
    private long id;
    private String chName;
    private String enName;
    private int type;
    private int ifScatter;
    private String scatterObj;
    private int canModify;
    private int needInput;
    private String value;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getChName() {
        return chName;
    }

    public void setChName(String chName) {
        this.chName = chName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIfScatter() {
        return ifScatter;
    }

    public void setIfScatter(int ifScatter) {
        this.ifScatter = ifScatter;
    }

    public String getScatterObj() {
        return scatterObj;
    }

    public void setScatterObj(String scatterObj) {
        this.scatterObj = scatterObj;
    }

    public int getCanModify() {
        return canModify;
    }

    public void setCanModify(int canModify) {
        this.canModify = canModify;
    }

    public int getNeedInput() {
        return needInput;
    }

    public void setNeedInput(int needInput) {
        this.needInput = needInput;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
