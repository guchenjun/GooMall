package com.milen.model.vo;

import com.milen.model.po.SPU;

import java.math.BigDecimal;
import java.util.Date;

public class GoodsVO {

    private Long id;

    private String spuName;

    private String spuImage;

    private Long category1Id;

    private Long category2Id;

    private Long brandId;

    private Long shopId;

    private String shopName;

    private Boolean isOn;

    private BigDecimal price;

    private String description;

    private Date gmtCreate;

    private Date gmtModified;

    public GoodsVO() {
    }

    public GoodsVO(SPU spu) {
        this.id = spu.getId();
        this.spuName = spu.getSpuName();
        this.spuImage = spu.getSpuImage();
        this.category1Id = spu.getCategory1Id();
        this.category2Id = spu.getCategory2Id();
        this.brandId = spu.getBrandId();
        this.shopId = spu.getShopId();
        this.isOn = spu.getOn();
        this.description = spu.getDescription();
        this.gmtCreate = spu.getGmtCreate();
        this.gmtModified = spu.getGmtModified();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Boolean getOn() {
        return isOn;
    }

    public void setOn(Boolean on) {
        isOn = on;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "GoodsVO{" +
                "id=" + id +
                ", spuName='" + spuName + '\'' +
                ", spuImage='" + spuImage + '\'' +
                ", category1Id=" + category1Id +
                ", category2Id=" + category2Id +
                ", brandId=" + brandId +
                ", shopId=" + shopId +
                ", shopName='" + shopName + '\'' +
                ", isOn=" + isOn +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
