package com.milen.model.po;

import java.io.Serializable;
import java.util.Date;

public class Ad implements Serializable {

    private Long id;

    private String adName;

    private String adUrl;

    private String adImage;

    private Boolean isOn;

    private Date gmtCreate;

    private Date gmtModified;

    public Ad() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getAdUrl() {
        return adUrl;
    }

    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl;
    }

    public String getAdImage() {
        return adImage;
    }

    public void setAdImage(String adImage) {
        this.adImage = adImage;
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

    public Boolean getOn() {
        return isOn;
    }

    public void setOn(Boolean on) {
        isOn = on;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", adName='" + adName + '\'' +
                ", adUrl='" + adUrl + '\'' +
                ", adImage='" + adImage + '\'' +
                ", isOn=" + isOn +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
