package com.milen.model.dto;

import java.io.Serializable;

public class CategoryDescriptionDTO implements Serializable {

    private String category1Name;

    private String category2Name;

    private String brandName;

    public CategoryDescriptionDTO() {
    }

    public String getCategory1Name() {
        return category1Name;
    }

    public void setCategory1Name(String category1Name) {
        this.category1Name = category1Name;
    }

    public String getCategory2Name() {
        return category2Name;
    }

    public void setCategory2Name(String category2Name) {
        this.category2Name = category2Name;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "CategoryDescriptionDTO{" +
                "category1Name='" + category1Name + '\'' +
                ", category2Name='" + category2Name + '\'' +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
