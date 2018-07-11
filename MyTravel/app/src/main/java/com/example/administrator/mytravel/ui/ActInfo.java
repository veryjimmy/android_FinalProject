package com.example.administrator.mytravel.ui;


public class ActInfo {
    private int _id;
    private String username;
    private String actTitle;
    private String actAddress;
    private String actNum;
    private String actTime;
    private String actContent;
    private String actImageUri;

    public ActInfo(int _id,String username,String actTitle, String actAddress, String actNum, String actTime, String actContent, String actImageUri) {
        this._id = _id;
        this.username = username;
        this.actTitle = actTitle;
        this.actAddress = actAddress;
        this.actNum = actNum;
        this.actTime = actTime;
        this.actContent = actContent;
        this.actImageUri = actImageUri;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getActImageUri() {
        return actImageUri;
    }

    public void setActImageUri(String actImageUri) {
        this.actImageUri = actImageUri;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getActTitle() {
        return actTitle;
    }

    public void setActTitle(String actTitle) {
        this.actTitle = actTitle;
    }



    public String getActNum() {
        return actNum;
    }

    public void setActNum(String actNum) {
        this.actNum = actNum;
    }

    public String getActTime() {
        return actTime;
    }

    public void setActTime(String actTime) {
        this.actTime = actTime;
    }

    public String getActContent() {
        return actContent;
    }

    public void setActContent(String actContent) {
        this.actContent = actContent;
    }

    public String getActAddress() {
        return actAddress;
    }

    public void setActAddress(String actAddress) {
        this.actAddress = actAddress;
    }
}
