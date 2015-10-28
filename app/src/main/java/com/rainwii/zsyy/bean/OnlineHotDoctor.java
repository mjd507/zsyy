package com.rainwii.zsyy.bean;

/**
 * 描述：
 * 作者 mjd
 * 日期：2015/10/28 12:50
 */
public class OnlineHotDoctor {
    private String imageUri;
    private String name;
    private String position;
    private String department;
    private String introduction;
    private String score;

    public OnlineHotDoctor() {

    }

    public OnlineHotDoctor(String imageUri, String name, String position, String department, String introduction, String score) {
        this.imageUri = imageUri;
        this.name = name;
        this.position = position;
        this.department = department;
        this.introduction = introduction;
        this.score = score;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
