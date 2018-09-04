package com.uv.entity;

public class CPEPExceptionCount {


    public String getEnterpriseID() {
        return enterpriseID;
    }

    public void setEnterpriseID(String enterpriseID) {
        this.enterpriseID = enterpriseID;
    }

    public int getExCount() {
        return exCount;
    }

    public void setExCount(int exCount) {
        this.exCount = exCount;
    }

    public String getCollectTime() {
        return CollectTime;
    }

    public void setCollectTime(String collectTime) {
        CollectTime = collectTime;
    }

    private String enterpriseID;
    private int exCount;
    private String CollectTime;
}
