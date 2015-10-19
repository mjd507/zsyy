package com.rainwii.zsyy.bean;

import java.io.Serializable;

/**
 * 描述：
 * 作者 mjd
 * 日期：2015/10/16 22:39
 */
public class ExpertScheduleInfo implements Serializable{
    private long dateId;
    private String date;
    private String name;
    private String rank;
    private String introduction;
    private boolean isAm;
    private boolean isPm;
    private String fee;
    private String count;

    public ExpertScheduleInfo() {
    }

    public ExpertScheduleInfo(long dateId, String date, String name, String rank, String introduction, boolean isAm, boolean isPm, String fee, String count) {
        this.dateId = dateId;
        this.date = date;
        this.name = name;
        this.rank = rank;
        this.introduction = introduction;
        this.isAm = isAm;
        this.isPm = isPm;
        this.fee = fee;
        this.count = count;
    }

    public long getDateId() {
        return dateId;
    }

    public void setDateId(long dateId) {
        this.dateId = dateId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public boolean isAm() {
        return isAm;
    }

    public void setIsAm(boolean isAm) {
        this.isAm = isAm;
    }

    public boolean isPm() {
        return isPm;
    }

    public void setIsPm(boolean isPm) {
        this.isPm = isPm;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}

