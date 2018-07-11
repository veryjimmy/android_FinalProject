package com.example.administrator.mytravel.ui;


public class StrategyInfo {
    private String strategyTitle;
    private String strategyContent;
    private int _id;
    private String username;
    private String strategyImageUri;

    public StrategyInfo(int _id,String username ,String strategyTitle,String strategyContent, String strategyImageUri) {
        this._id = _id;
        this.username = username;
        this.strategyTitle = strategyTitle;
        this.strategyContent = strategyContent;
        this.strategyImageUri = strategyImageUri;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStrategyTitle() {
        return strategyTitle;
    }

    public void setStrategyTitle(String strategyTitle) {
        this.strategyTitle = strategyTitle;
    }

    public String getStrategyContent() {
        return strategyContent;
    }

    public void setStrategyContent(String strategyContent) {
        this.strategyContent = strategyContent;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getStrategyImageUri() {
        return strategyImageUri;
    }

    public void setStrategyImageUri(String strategyImageUri) {
        this.strategyImageUri = strategyImageUri;
    }
}
