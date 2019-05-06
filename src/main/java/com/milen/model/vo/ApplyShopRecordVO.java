package com.milen.model.vo;

import com.milen.model.dto.ApplyShopRecordDTO;

import java.util.Date;

public class ApplyShopRecordVO {

    private Long id;

    private String realName;

    private Integer credit;

    private String shopName;

    private String shopDescription;

    private Date gmtCreate;

    private Date gmtModified;

    private String reviewAdmin;

    private String reviewStatus;

    public ApplyShopRecordVO() {
    }

    public ApplyShopRecordVO(ApplyShopRecordDTO recordDTO, String admin, String status) {
        this.id = recordDTO.getId();
        this.realName = recordDTO.getRealName();
        this.credit = recordDTO.getCredit();
        this.shopName = recordDTO.getShopName();
        this.shopDescription = recordDTO.getShopDescription();
        this.gmtCreate = recordDTO.getGmtCreate();
        this.gmtModified = recordDTO.getGmtModified();
        this.reviewAdmin = admin;
        this.reviewStatus = status;
    }

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

    public String getReviewAdmin() {
        return reviewAdmin;
    }

    public void setReviewAdmin(String reviewAdmin) {
        this.reviewAdmin = reviewAdmin;
    }

    public String getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(String reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    @Override
    public String toString() {
        return "ApplyShopRecordVO{" +
                "id=" + id +
                ", realName='" + realName + '\'' +
                ", credit=" + credit +
                ", shopName='" + shopName + '\'' +
                ", shopDescription='" + shopDescription + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", reviewAdmin='" + reviewAdmin + '\'' +
                ", reviewStatus='" + reviewStatus + '\'' +
                '}';
    }
}
