package com.milen.model.vo;

public class AttrValueSKUVO {

    private String attrValue;

    private SKUVO skuVO;

    public AttrValueSKUVO() {
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    public SKUVO getSkuVO() {
        return skuVO;
    }

    public void setSkuVO(SKUVO skuVO) {
        this.skuVO = skuVO;
    }

    @Override
    public String toString() {
        return "AttrValueSKUVO{" +
                "attrValue='" + attrValue + '\'' +
                ", skuVO=" + skuVO +
                '}';
    }
}
