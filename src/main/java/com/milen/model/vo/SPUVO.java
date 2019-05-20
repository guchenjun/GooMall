package com.milen.model.vo;

import com.milen.model.po.SPU;

import java.util.Date;

public class SPUVO {
    private Long id;

    private String spuName;

    private String spuImage;

    private String category;

    private Date gmtCreate;

    private Date gmtModified;

    private String isOn;

    public SPUVO() {
    }

    public SPUVO(SPU spu, String category) {
        this.id = spu.getId();
        this.spuName = spu.getSpuName();
        this.spuImage = spu.getSpuImage();
        this.category = category;
        this.gmtCreate = spu.getGmtCreate();
        this.gmtModified = spu.getGmtModified();
        if (spu.getOn()) {
            this.isOn = "已上架";
        } else {
            this.isOn = "未上架";
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpuName() {
        return spuName;
    }

    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    public String getSpuImage() {
        return spuImage;
    }

    public void setSpuImage(String spuImage) {
        this.spuImage = spuImage;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getIsOn() {
        return isOn;
    }

    public void setIsOn(String isOn) {
        this.isOn = isOn;
    }

    @Override
    public String toString() {
        return "SPUVO{" +
                "id=" + id +
                ", spuName='" + spuName + '\'' +
                ", spuImage='" + spuImage + '\'' +
                ", category='" + category + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", isOn='" + isOn + '\'' +
                '}';
    }

}
