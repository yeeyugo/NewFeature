package com.yee.feature.ui.bean;

/**
 * Create by: Bean
 * Create on: 2021/1/23 23:29
 * Description:
 */
public class FruitBean {
    private int imageId;
    private String title;
    private String content;

    public FruitBean(int imageId, String title, String content) {
        this.imageId = imageId;
        this.title = title;
        this.content = content;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
