package com.milen.pojo.po;

import java.math.BigDecimal;
import java.util.Date;

public class Shop {

    private Long id;

    private Long userId;

    private String shopImage;

    private String shopName;

    private String shopAddress;

    private String shopDescription;

    private BigDecimal shopScore;

    private BigDecimal shopDeposit;

    private BigDecimal shopAccount;

    private Boolean shopStatus;

    private Date gmtCreate;

    private Date gmtModified;

    public Shop() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getShopImage() {
        return shopImage;
    }

    public void setShopImage(String shopImage) {
        this.shopImage = shopImage;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getShopDescription() {
        return shopDescription;
    }

    public void setShopDescription(String shopDescription) {
        this.shopDescription = shopDescription;
    }

    public BigDecimal getShopScore() {
        return shopScore;
    }

    public void setShopScore(BigDecimal shopScore) {
        this.shopScore = shopScore;
    }

    public BigDecimal getShopDeposit() {
        return shopDeposit;
    }

    public void setShopDeposit(BigDecimal shopDeposit) {
        this.shopDeposit = shopDeposit;
    }

    public BigDecimal getShopAccount() {
        return shopAccount;
    }

    public void setShopAccount(BigDecimal shopAccount) {
        this.shopAccount = shopAccount;
    }

    public Boolean getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(Boolean shopStatus) {
        this.shopStatus = shopStatus;
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
        return "Shop{" +
                "id=" + id +
                ", userId=" + userId +
                ", shopImage='" + shopImage + '\'' +
                ", shopName='" + shopName + '\'' +
                ", shopAddress='" + shopAddress + '\'' +
                ", shopDescription='" + shopDescription + '\'' +
                ", shopScore=" + shopScore +
                ", shopDeposit=" + shopDeposit +
                ", shopAccount=" + shopAccount +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
