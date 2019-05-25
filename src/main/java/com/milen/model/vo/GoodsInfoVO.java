package com.milen.model.vo;

import java.util.List;

public class GoodsInfoVO {

    private String attrName;

    private List<AttrValueSKUVO> attrValueSKUVOList;

    public GoodsInfoVO() {
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public List<AttrValueSKUVO> getAttrValueSKUVOList() {
        return attrValueSKUVOList;
    }

    public void setAttrValueSKUVOList(List<AttrValueSKUVO> attrValueSKUVOList) {
        this.attrValueSKUVOList = attrValueSKUVOList;
    }

    @Override
    public String toString() {
        return "GoodsInfoVO{" +
                "attrName='" + attrName + '\'' +
                ", attrValueSKUVOList=" + attrValueSKUVOList +
                '}';
    }
}
