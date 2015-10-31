package com.rainwii.zsyy.bean;

/**
 * 描述：
 * 作者 mjd
 * 日期：2015/10/31 15:17
 */
public class SubscribeSpecial {
    private String imageUri;
    private String title;

    public SubscribeSpecial() {
    }

    public SubscribeSpecial(String imageUri, String title) {
        this.imageUri = imageUri;
        this.title = title;
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
}
