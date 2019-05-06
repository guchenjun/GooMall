package com.milen.model.vo;

import com.milen.model.po.Brand;
import com.milen.model.po.BrandCategory;
import com.milen.model.po.Category1;
import com.milen.model.po.Category2;

import java.util.List;

public class GoodsCategoryVO {

    private List<Category1> category1List;
    private List<Category2> category2List;
    private List<Brand> brandList;
    private List<BrandCategory> brandCategoryList;

    public GoodsCategoryVO() {
    }

    public GoodsCategoryVO(List<Category1> category1List, List<Category2> category2List, List<Brand> brandList, List<BrandCategory> brandCategoryList) {
        this.category1List = category1List;
        this.category2List = category2List;
        this.brandList = brandList;
        this.brandCategoryList = brandCategoryList;
    }

    public List<Category1> getCategory1List() {
        return category1List;
    }

    public void setCategory1List(List<Category1> category1List) {
        this.category1List = category1List;
    }

    public List<Category2> getCategory2List() {
        return category2List;
    }

    public void setCategory2List(List<Category2> category2List) {
        this.category2List = category2List;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

    public List<BrandCategory> getBrandCategoryList() {
        return brandCategoryList;
    }

    public void setBrandCategoryList(List<BrandCategory> brandCategoryList) {
        this.brandCategoryList = brandCategoryList;
    }

    @Override
    public String toString() {
        return "GoodsCategoryVO{" +
                "category1List=" + category1List +
                ", category2List=" + category2List +
                ", brandList=" + brandList +
                ", brandCategoryList=" + brandCategoryList +
                '}';
    }
}
