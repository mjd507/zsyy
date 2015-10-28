package com.rainwii.zsyy.bean;

/**
 * 描述：
 * 作者 mjd
 * 日期：2015/10/28 16:27
 */
public class OnlineHotDoctorDetailQuestion {
    private String name;
    private String score;
    private String date;
    private String question;
    private String content;

    public OnlineHotDoctorDetailQuestion(String name, String score, String date, String question, String content) {
        this.name = name;
        this.score = score;
        this.date = date;
        this.question = question;
        this.content = content;
    }

    public OnlineHotDoctorDetailQuestion() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
