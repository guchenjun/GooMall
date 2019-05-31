package com.milen.service;

import com.milen.model.dto.CategoryBrandDTO;

import java.util.List;
import java.util.Map;

public interface AttributeService {

    List<Map<String, Object>> getAttributesListByCategory2(Long id);

    String getAttrNameByAttrId(Long attrId);

    boolean saveAttrValueAndAttrNameByAttrId(String attrName, String attrValue, Long attrId);

    List<Map<String, Object>> getAttributeListBySPUId(Long spuId);

    boolean saveBrandByCategoryDTO(CategoryBrandDTO categoryBrandDTO);

    boolean saveAttrName(String attrName, Long category2Id);

    String getAttrNameById(Long attrId);
}
