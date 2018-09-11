package com.uv.entity;

public class CPTimeOutExceptionPerDay {
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

    private int exCount;
    private String CollectTime;
}
