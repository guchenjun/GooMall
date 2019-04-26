package com.milen.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class Shop {

    private BigInteger id;

    private BigInteger userId;

    private String shopImage;

    private String shopName;

    private String shopAddress;

    private String shopDescription;

    private BigDecimal shopScore;

    private BigDecimal shopDeposit;

    private BigDecimal shopAccount;

    private Date gmtCreate;

    private Date gmtModified;

    public Shop() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
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
