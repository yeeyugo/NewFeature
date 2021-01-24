package com.yee.feature.ui.bean;

/**
 * Create by: Bean
 * Create on: 2021/1/24 16:35
 * Description:
 */
public class MainBean {
    private int itemType;
    private String data;

    public MainBean(int itemType, String data) {
        this.itemType = itemType;
        this.data = data;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
