package com.yee.feature.ui.bean;

/**
 * Create by: Bean
 * Create on: 2021/1/24 14:38
 * Description:
 */
public class HeaderBean {
    private int itemType;
    private int headerImageId;
    private String footerText;
    private FruitBean fruit;

    public HeaderBean(int itemType, FruitBean fruit) {
        this.itemType = itemType;
        this.fruit = fruit;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public FruitBean getFruit() {
        return fruit;
    }

    public void setFruit(FruitBean fruit) {
        this.fruit = fruit;
    }
}
