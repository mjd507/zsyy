package com.rainwii.zsyy.bean;

/**
 * 描述：
 * 作者 mjd
 * 日期：2015/10/29 11:41
 */
public class ReservationSetMeal {
    private String name;
    private String belong;
    private String manCost;
    private String womenCost;
    private String detail;
    private String content;

    public ReservationSetMeal() {
    }

    public ReservationSetMeal(String name, String belong, String manCost, String womenCost, String detail, String content) {
        this.name = name;
        this.belong = belong;
        this.manCost = manCost;
        this.womenCost = womenCost;
        this.detail = detail;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public String getManCost() {
        return manCost;
    }

    public void setManCost(String manCost) {
        this.manCost = manCost;
    }

    public String getWomenCost() {
        return womenCost;
    }

    public void setWomenCost(String womenCost) {
        this.womenCost = womenCost;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
