package com.rainwii.zsyy.bean;

/**
 * 描述：
 * 作者 mjd
 * 日期：2015/10/19 21:44
 */
public class Call {
    private String num;
    private String faculty;
    private String date;

    public Call() {
    }

    public Call(String num, String faculty, String date) {
        this.num = num;
        this.faculty = faculty;
        this.date = date;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
