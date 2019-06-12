package com.milen.model.dto;


import java.io.Serializable;
import java.util.Date;

public class ApplyShopRecordDTO implements Serializable {

    private Long id;

    private String realName;

    private Integer credit;

    private String shopName;

    private String shopDescription;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer adminId;

    private Boolean reviewStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopDescription() {
        return shopDescription;
    }

    public void setShopDescription(String shopDescription) {
        this.shopDescription = shopDescription;
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

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Boolean getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(Boolean reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    @Override
    public String toString() {
        return "ApplyShopRecordDTO{" +
                "id=" + id +
                ", realName='" + realName + '\'' +
                ", credit=" + credit +
                ", shopName='" + shopName + '\'' +
                ", shopDescription='" + shopDescription + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", adminId=" + adminId +
                ", reviewStatus=" + reviewStatus +
                '}';
    }
}
