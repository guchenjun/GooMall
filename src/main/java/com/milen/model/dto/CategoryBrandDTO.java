package com.milen.model.dto;

import java.util.Date;

public class CategoryBrandDTO {

    private Long id;

    private Long category1Id;

    private Long category2Id;

    private String brandName;

    private Date date;

    public CategoryBrandDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategory1Id() {
        return category1Id;
    }

    public void setCategory1Id(Long category1Id) {
        this.category1Id = category1Id;
    }

    public Long getCategory2Id() {
        return category2Id;
    }

    public void setCategory2Id(Long category2Id) {
        this.category2Id = category2Id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CategoryBrandDTO{" +
                "id=" + id +
                ", category1Id=" + category1Id +
                ", category2Id=" + category2Id +
                ", brandName='" + brandName + '\'' +
                ", date=" + date +
                '}';
    }
}
