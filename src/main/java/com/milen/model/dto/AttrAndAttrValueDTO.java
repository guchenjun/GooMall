package com.milen.model.dto;

import java.io.Serializable;

public class AttrAndAttrValueDTO implements Serializable {

    private Long attrId;

    private Long attrValueId;

    public AttrAndAttrValueDTO() {
    }

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public Long getAttrValueId() {
        return attrValueId;
    }

    public void setAttrValueId(Long attrValueId) {
        this.attrValueId = attrValueId;
    }

    @Override
    public String toString() {
        return "AttrAndAttrValueDTO{" +
                "attrId=" + attrId +
                ", attrValueId=" + attrValueId +
                '}';
    }
}
