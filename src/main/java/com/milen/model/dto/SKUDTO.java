package com.milen.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class SKUDTO implements Serializable {

    private Long id;

    private String skuName;

    private Long skuStock;

    private BigDecimal skuPrice;

    private List<Long> attributes;

    private List<String> skuImages;

    public SKUDTO() {
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

    public Long getSkuStock() {
        return skuStock;
    }

    public void setSkuStock(Long skuStock) {
        this.skuStock = skuStock;
    }

    public BigDecimal getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(BigDecimal skuPrice) {
        this.skuPrice = skuPrice;
    }

    public List<Long> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Long> attributes) {
        this.attributes = attributes;
    }

    public List<String> getSkuImages() {
        return skuImages;
    }

    public void setSkuImages(List<String> skuImages) {
        this.skuImages = skuImages;
    }

    @Override
    public String toString() {
        return "SKUDTO{" +
                "id=" + id +
                ", skuName='" + skuName + '\'' +
                ", skuStock=" + skuStock +
                ", skuPrice=" + skuPrice +
                ", attributes=" + attributes +
                ", skuImages=" + skuImages +
                '}';
    }
}
