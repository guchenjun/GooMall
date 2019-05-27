package com.milen.model.vo;

import com.milen.model.dto.ShopCartDTO;

import java.math.BigDecimal;

public class ShopCartVO {
    private Long id;

    private Long spuId;

    private Long skuId;

    private String skuName;

    private String image;

    private BigDecimal price;

    private Long amount;

    private BigDecimal totalPrice;

    private String attrDescription;

    public ShopCartVO() {
    }

    public ShopCartVO(ShopCartDTO shopCartDTO) {
        this.id = shopCartDTO.getId();
        this.spuId = shopCartDTO.getSpuId();
        this.skuId = shopCartDTO.getSkuId();
        this.skuName = shopCartDTO.getSkuName();
        this.image = shopCartDTO.getImage();
        this.price = shopCartDTO.getPrice();
        this.amount = shopCartDTO.getAmount();
        this.attrDescription = shopCartDTO.getAttrDescription();
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

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAttrDescription() {
        return attrDescription;
    }

    public void setAttrDescription(String attrDescription) {
        this.attrDescription = attrDescription;
    }

    @Override
    public String toString() {
        return "ShopCartVO{" +
                "id=" + id +
                ", spuId=" + spuId +
                ", skuId=" + skuId +
                ", skuName='" + skuName + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", totalPrice=" + totalPrice +
                ", attrDescription='" + attrDescription + '\'' +
                '}';
    }
}
