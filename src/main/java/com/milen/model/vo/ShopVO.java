package com.milen.model.vo;

import com.milen.model.po.Shop;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ShopVO implements Serializable {
    private Long id;

    private Long userId;

    private String sellerName;

    private String shopImage;

    private String shopName;

    private String shopAddress;

    private String shopDescription;

    private BigDecimal shopScore;

    private BigDecimal shopDeposit;

    private BigDecimal shopAccount;

    private String shopStatus;

    private Date openTime;

    private Date gmtCreate;

    private Date gmtModified;


    public ShopVO(Shop shop, String shopStatus, Date openTime) {
        this.id = shop.getId();
        this.userId = shop.getUserId();
        this.shopImage = shop.getShopImage();
        this.shopName = shop.getShopName();
        this.shopAddress = shop.getShopAddress();
        this.shopDescription = shop.getShopDescription();
        this.shopScore = shop.getShopScore();
        this.shopDeposit = shop.getShopDeposit();
        this.shopAccount = shop.getShopAccount();
        this.shopStatus = shopStatus;
        this.gmtCreate = shop.getGmtCreate();
        this.gmtModified = shop.getGmtModified();
        this.openTime = openTime;
    }

    public ShopVO(Shop shop, String shopStatus) {
        this.id = shop.getId();
        this.userId = shop.getUserId();
        this.shopImage = shop.getShopImage();
        this.shopName = shop.getShopName();
        this.shopAddress = shop.getShopAddress();
        this.shopDescription = shop.getShopDescription();
        this.shopScore = shop.getShopScore();
        this.shopDeposit = shop.getShopDeposit();
        this.shopAccount = shop.getShopAccount();
        this.shopStatus = shopStatus;
        this.gmtCreate = shop.getGmtCreate();
        this.gmtModified = shop.getGmtModified();
    }

    public ShopVO(Shop shop, String shopStatus, String sellerName) {
        this.id = shop.getId();
        this.userId = shop.getUserId();
        this.shopImage = shop.getShopImage();
        this.shopName = shop.getShopName();
        this.shopAddress = shop.getShopAddress();
        this.shopDescription = shop.getShopDescription();
        this.shopScore = shop.getShopScore();
        this.shopDeposit = shop.getShopDeposit();
        this.shopAccount = shop.getShopAccount();
        this.shopStatus = shopStatus;
        this.gmtCreate = shop.getGmtCreate();
        this.gmtModified = shop.getGmtModified();
        this.sellerName = sellerName;
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

    public String getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(String shopStatus) {
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

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    @Override
    public String toString() {
        return "ShopVO{" +
                "id=" + id +
                ", userId=" + userId +
                ", sellerName='" + sellerName + '\'' +
                ", shopImage='" + shopImage + '\'' +
                ", shopName='" + shopName + '\'' +
                ", shopAddress='" + shopAddress + '\'' +
                ", shopDescription='" + shopDescription + '\'' +
                ", shopScore=" + shopScore +
                ", shopDeposit=" + shopDeposit +
                ", shopAccount=" + shopAccount +
                ", shopStatus='" + shopStatus + '\'' +
                ", openTime=" + openTime +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
