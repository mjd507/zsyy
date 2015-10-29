package com.rainwii.zsyy.bean;

/**
 * 描述：
 * 作者 mjd
 * 日期：2015/10/29 13:59
 */
public class ReservationSetMealDetail {
    private String lcjc;
    private String belong;
    private String sysjc;
    private String yqjc;
    private String other;

    public ReservationSetMealDetail(String lcjc, String belong, String sysjc, String yqjc, String other) {
        this.lcjc = lcjc;
        this.belong = belong;
        this.sysjc = sysjc;
        this.yqjc = yqjc;
        this.other = other;
    }

    public ReservationSetMealDetail() {

    }

    public String getLcjc() {
        return lcjc;
    }

    public void setLcjc(String lcjc) {
        this.lcjc = lcjc;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public String getSysjc() {
        return sysjc;
    }

    public void setSysjc(String sysjc) {
        this.sysjc = sysjc;
    }

    public String getYqjc() {
        return yqjc;
    }

    public void setYqjc(String yqjc) {
        this.yqjc = yqjc;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
