package com.rainwii.zsyy.bean;

/**
 * 描述：
 * 作者 mjd
 * 日期：2015/10/31 16:08
 */
public class SubscribeChild {
    private String imageUri;
    private String title;
    private String date;

    public SubscribeChild() {
    }

    public SubscribeChild(String imageUri, String title, String date) {
        this.imageUri = imageUri;
        this.title = title;
        this.date = date;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
