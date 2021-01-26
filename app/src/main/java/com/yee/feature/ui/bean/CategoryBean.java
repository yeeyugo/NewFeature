package com.yee.feature.ui.bean;

/**
 * Create by: Bean
 * Create on: 2021/1/26 7:55
 * Description:
 */
public class CategoryBean {
    private int viewType;
    private String categoryName;
    private PlantBean plant;

    public CategoryBean(int viewType, String categoryName, PlantBean plant) {
        this.viewType = viewType;
        this.categoryName = categoryName;
        this.plant = plant;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public PlantBean getPlant() {
        return plant;
    }

    public void setPlant(PlantBean plant) {
        this.plant = plant;
    }
}
