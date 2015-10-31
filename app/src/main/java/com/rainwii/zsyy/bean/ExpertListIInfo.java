package com.rainwii.zsyy.bean;

import java.io.Serializable;

/**
 * 描述：专家排班 --> 专家列表
 * 作者 mjd
 * 日期：2015/10/26 9:38
 */
public class ExpertListIInfo implements Serializable {
    private String imageUri;
    private String name;
    private String position;
    private String skill;

    public ExpertListIInfo() {
    }

    public ExpertListIInfo(String imageUri, String name, String position, String skill) {
        this.imageUri = imageUri;
        this.name = name;
        this.position = position;
        this.skill = skill;
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

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
