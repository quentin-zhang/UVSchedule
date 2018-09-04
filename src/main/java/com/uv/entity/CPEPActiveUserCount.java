package com.uv.entity;

public class CPEPActiveUserCount {
    public String getEnterpriseID() {
        return enterpriseID;
    }

    public void setEnterpriseID(String enterpriseID) {
        this.enterpriseID = enterpriseID;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public String getCollectTime() {
        return CollectTime;
    }

    public void setCollectTime(String collectTime) {
        CollectTime = collectTime;
    }

    private String enterpriseID;
    private int userCount;
    private String CollectTime;
}
