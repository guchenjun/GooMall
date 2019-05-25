package com.milen.model.po;

import java.math.BigDecimal;
import java.util.Date;

public class SKU {

    private Long id;

    private Long spuId;

    private String skuName;

    private Long stock;

    private BigDecimal isOn;

    private BigDecimal price;

    private Date gmtCreate;

    private Date gmtModified;

    public SKU() {
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

    public BigDecimal getIsOn() {
        return isOn;
    }

    public void setIsOn(BigDecimal isOn) {
        this.isOn = isOn;
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
        return "SKU{" +
                "id=" + id +
                ", spuId=" + spuId +
                ", skuName='" + skuName + '\'' +
                ", stock=" + stock +
                ", isOn=" + isOn +
                ", price=" + price +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
