package com.rainwii.zsyy.bean;

/**
 * 描述：
 * 作者 mjd
 * 日期：2015/10/28 12:50
 */
public class OnlineNewQuestion {
    private String question;
    private String imageUri;
    private String name;
    private String position;
    private String createTime;
    private String department;
    private String reply;

    public OnlineNewQuestion(String question, String imageUri, String name, String position, String createTime, String department, String reply) {
        this.question = question;
        this.imageUri = imageUri;
        this.name = name;
        this.position = position;
        this.createTime = createTime;
        this.department = department;
        this.reply = reply;
    }

    public OnlineNewQuestion() {

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}
