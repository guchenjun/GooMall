package com.milen.model.vo;

import java.io.Serializable;
import java.util.Date;

public class SPUAdminVO implements Serializable {
    /**
     * <th>商品id</th>
     * <th>商家名称</th>
     * <th>商品名称</th>
     * <th>商品封面</th>
     * <th>商品分类</th>
     * <th>上架时间</th>
     * <th>修改时间</th>
     * <th>状态</th>
     */
    private Long id;

    private String shopName;

    private String spuName;

    private String image;

    private String categoryDescription;

    private Boolean isOn;

    private Date gmtCreate;

    private Date gmtModified;

    public SPUAdminVO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getSpuName() {
        return spuName;
    }

    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
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
        return "SPUAdminVO{" +
                "id=" + id +
                ", shopName='" + shopName + '\'' +
                ", spuName='" + spuName + '\'' +
                ", image='" + image + '\'' +
                ", categoryDescription='" + categoryDescription + '\'' +
                ", isOn=" + isOn +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
