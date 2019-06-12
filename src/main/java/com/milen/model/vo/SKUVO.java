package com.milen.model.vo;

import com.milen.model.po.SKU;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class SKUVO implements Serializable {

    private Long id;

    private Long spuId;

    private String skuName;

    private Long stock;

    private BigDecimal price;

    private List<String> images;

    private Date gmtCreate;

    public SKUVO() {
    }

    public SKUVO(SKU sku, List<String> images) {
        this.id = sku.getId();
        this.spuId = sku.getSpuId();
        this.skuName = sku.getSkuName();
        this.stock = sku.getStock();
        this.price = sku.getPrice();
        this.gmtCreate = sku.getGmtCreate();
        this.images = images;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    @Override
    public String toString() {
        return "SKUVO{" +
                "id=" + id +
                ", spuId=" + spuId +
                ", skuName='" + skuName + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", images=" + images +
                ", gmtCreate=" + gmtCreate +
                '}';
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

}
