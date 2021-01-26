package com.yee.feature.ui.bean;

/**
 * Create by: Bean
 * Create on: 2021/1/26 7:58
 * Description:
 */
public class PlantBean {
    private int imageId;
    private String name;
    private String detail;
    private boolean isFood;

    public PlantBean(int imageId, String name, String detail, boolean isFood) {
        this.imageId = imageId;
        this.name = name;
        this.detail = detail;
        this.isFood = isFood;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public boolean isFood() {
        return isFood;
    }

    public void setFood(boolean food) {
        isFood = food;
    }
}
