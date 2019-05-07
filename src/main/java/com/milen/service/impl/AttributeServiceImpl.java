package com.milen.service.impl;

import com.milen.mapper.AttributeMapper;
import com.milen.model.po.AttributeValue;
import com.milen.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service("attributeService")
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    AttributeMapper attributeMapper;

    @Override
    public List<Map<String, Object>> getAttributeIdsByCategory2(Long id) {
        List<Long> idList = attributeMapper.getAttributeIdsByCategory2(id);
        List<AttributeValue> attributeNameAndValueList = attributeMapper.getAttributeNameAndValueByIds(idList);
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < attributeNameAndValueList.size(); i++) {
            String attrName = attributeNameAndValueList.get(i).getAttrName();
            String attrValue = attributeNameAndValueList.get(i).getAttrValue();
            if (!map.containsKey(attrName)) {
                List<String> valueList = new ArrayList<>();
                valueList.add(attrValue);
                map.put(attrName, valueList);
            } else {
                map.get(attrName).add(attrValue);
            }
        }
        List<Map<String, Object>> mapEntryList = new ArrayList<>();
        Iterator<Map.Entry<String, List<String>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<String>> entry = iterator.next();
            Map<String, Object> mMap = new HashMap();
            mMap.put("name", entry.getKey());
            mMap.put("values", entry.getValue());
            mapEntryList.add(mMap);
        }
        return mapEntryList;
    }
}
