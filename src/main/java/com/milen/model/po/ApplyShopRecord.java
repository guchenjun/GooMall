package com.milen.model.po;

import java.io.Serializable;
import java.util.Date;

public class ApplyShopRecord implements Serializable {

    private Long id;

    private Long shopId;

    private Long userId;

    private Long adminId;

    private Boolean reviewStatus;

    private Date gmtCreate;

    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Boolean getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(Boolean reviewStatus) {
        this.reviewStatus = reviewStatus;
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
        return "ApplyShopRecord{" +
                "shopId=" + shopId +
                ", userId=" + userId +
                ", adminId=" + adminId +
                ", reviewStatus=" + reviewStatus +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
