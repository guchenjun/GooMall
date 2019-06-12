package com.milen.model.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TradeOrderSellerVO implements Serializable {

    private Long id;

    private Long spuId;

    private String skuName;

    private String image;

    private String attrDescription;

    private BigDecimal price;

    private Integer amount;

    private BigDecimal totalPrice;

    private String buyerName;

    private Date date;

    public TradeOrderSellerVO() {
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAttrDescription() {
        return attrDescription;
    }

    public void setAttrDescription(String attrDescription) {
        this.attrDescription = attrDescription;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TradeOrderSellerVO{" +
                "id=" + id +
                ", spuId=" + spuId +
                ", skuName='" + skuName + '\'' +
                ", image='" + image + '\'' +
                ", attrDescription='" + attrDescription + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", totalPrice=" + totalPrice +
                ", buyerName='" + buyerName + '\'' +
                ", date=" + date +
                '}';
    }
}
