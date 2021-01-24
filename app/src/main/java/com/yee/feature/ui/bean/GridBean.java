package com.yee.feature.ui.bean;

/**
 * Create by: Bean
 * Create on: 2021/1/24 19:42
 * Description:
 */
public class GridBean {
    private int viewType;
    private int imageId;

    public GridBean(int viewType, int imageId) {
        this.viewType = viewType;
        this.imageId = imageId;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
