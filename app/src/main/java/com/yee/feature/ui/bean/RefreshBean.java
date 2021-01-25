package com.yee.feature.ui.bean;

/**
 * Create by: Bean
 * Create on: 2021/1/26 6:06
 * Description:
 */
public class RefreshBean {
    private int viewType;
    private int headerImageId;
    private FruitBean fruit;

    public RefreshBean(int viewType, int headerImageId, FruitBean fruit) {
        this.viewType = viewType;
        this.headerImageId = headerImageId;
        this.fruit = fruit;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public int getHeaderImageId() {
        return headerImageId;
    }

    public void setHeaderImageId(int headerImageId) {
        this.headerImageId = headerImageId;
    }

    public FruitBean getFruit() {
        return fruit;
    }

    public void setFruit(FruitBean fruit) {
        this.fruit = fruit;
    }
}
