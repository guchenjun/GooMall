package com.milen.service;

import java.util.List;
import java.util.Map;

public interface AttributeService {

    List<Map<String, Object>> getAttributesListByCategory2(Long id);

    String getAttrNameByAttrId(Long attrId);

    boolean saveAttrValueAndAttrNameByAttrId(String attrName, String attrValue, Long attrId);
}
