package com.milen.model.vo;

public class ReleaseGoodsVO {

    private String spuName;

    private String spuImage;

    private Long category1Id;

    private Long category2Id;

    private Long brandId;

    private Long shopId;

    private String description;

    public ReleaseGoodsVO() {
    }

    public String getSpuName() {
        return spuName;
    }

    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    public String getSpuImage() {
        return spuImage;
    }

    public void setSpuImage(String spuImage) {
        this.spuImage = spuImage;
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

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ReleaseGoodsVO{" +
                "spuName='" + spuName + '\'' +
                ", spuImage='" + spuImage + '\'' +
                ", category1Id=" + category1Id +
                ", category2Id=" + category2Id +
                ", brandId=" + brandId +
                ", shopId=" + shopId +
                ", description='" + description + '\'' +
                '}';
    }
}
