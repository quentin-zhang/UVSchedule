package com.uv.entity;

public class CPUserPV {

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPvCount() {
        return pvCount;
    }

    public void setPvCount(int pvCount) {
        this.pvCount = pvCount;
    }

    private String userID;
    private String userName;
    private int pvCount;
}
