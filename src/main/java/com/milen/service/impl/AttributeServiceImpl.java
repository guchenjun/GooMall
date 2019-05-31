package com.milen.service.impl;

import com.milen.mapper.AttributeMapper;
import com.milen.mapper.GoodsMapper;
import com.milen.model.dto.AttributeValueDTO;
import com.milen.model.dto.CategoryBrandDTO;
import com.milen.model.po.AttributeValue;
import com.milen.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service("attributeService")
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    AttributeMapper attributeMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<Map<String, Object>> getAttributesListByCategory2(Long id) {
        List<Map<String, Object>> mapEntryList = new ArrayList<>();
        try {
            List<Long> idList = attributeMapper.getAttributeIdsByCategory2(id);
            Map<String, List<String>> map = new HashMap<>();
            if (idList.size() != 0) {
                // 无attr_value的为空，重新设计【一次查一个，如果values为空，赋值[]数组】
//                List<AttributeValue> attributeNameAndValueList = attributeMapper.getAttributeNameAndValueByIds(idList);
                for (int i = 0; i < idList.size(); i++) {
                    List<AttributeValue> attributeNameAndValueList = attributeMapper.getAttributeNameAndValueById(idList.get(i));
                    if (attributeNameAndValueList.size() == 0) {
                        String attrName = attributeMapper.getAttrNameById(idList.get(i));
                        map.put(attrName + "," + idList.get(i),  new ArrayList<String>());
                        continue;
                    }
                    for (int j = 0; j < attributeNameAndValueList.size(); j++) {
                        Long attrId = attributeNameAndValueList.get(j).getAttrId();
                        String attrName = attributeNameAndValueList.get(j).getAttrName();
                        String attrValue = attributeNameAndValueList.get(j).getAttrValue();
                        if (!map.containsKey(attrName + "," + attrId)) {
                            List<String> valueList = new ArrayList<>();
                            valueList.add(attrValue);
                            map.put(attrName + "," + attrId, valueList);
                        } else {
                            map.get(attrName + "," + attrId).add(attrValue);
                        }
                    }
                }
//                for (int i = 0; i < attributeNameAndValueList.size(); i++) {
//                    Long attrId = attributeNameAndValueList.get(i).getAttrId();
//                    String attrName = attributeNameAndValueList.get(i).getAttrName();
//                    String attrValue = attributeNameAndValueList.get(i).getAttrValue();
//                    if (!map.containsKey(attrName + "," + attrId)) {
//                        List<String> valueList = new ArrayList<>();
//                        valueList.add(attrValue);
//                        map.put(attrName + "," + attrId, valueList);
//                    } else {
//                        map.get(attrName + "," + attrId).add(attrValue);
//                    }
//                }

                Iterator<Map.Entry<String, List<String>>> iterator = map.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, List<String>> entry = iterator.next();
                    Map<String, Object> mMap = new HashMap();
                    mMap.put("attrId", entry.getKey().split(",")[1]);
                    mMap.put("name", entry.getKey().split(",")[0]);
                    mMap.put("values", entry.getValue());
                    mapEntryList.add(mMap);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return mapEntryList;
    }

    @Override
    public String getAttrNameByAttrId(Long attrId) {
        return attributeMapper.getAttrNameByAttrId(attrId);
    }

    @Override
    public boolean saveAttrValueAndAttrNameByAttrId(String attrName, String attrValue, Long attrId) {
        Date gmtModified = new Date();
        int row = attributeMapper.insertAttrValueAndAttrNameByAttrId(attrName, attrValue, attrId, gmtModified);
        return row > 0;
    }

    @Override
    public List<Map<String, Object>> getAttributeListBySPUId(Long spuId) {
        Long category2Id = goodsMapper.getCategory2IdBySPUId(spuId);
        List<Long> attrIdList = attributeMapper.listAttrIdListByCategory2Id(category2Id);
        List<AttributeValueDTO> attributeValueDTOList = attributeMapper.listAttrValueDTOByAttrIdList(attrIdList);
        List<Map<String, Object>> mapList = new ArrayList<>();
        Set<String> set = new HashSet<>();
        // [{name: '颜色', values: [{attrId: 1, attrValueId: 2, attrName: '白色'}, {attrId: 1, attrValueId: 3, attrName: '黑色'}]}]
        for (int i = 0; i < attributeValueDTOList.size(); i++) {
            AttributeValueDTO attributeValueDTO = attributeValueDTOList.get(i);
            String attrName = attributeValueDTO.getAttrName();
            if (set.add(attrName)) {
                // values属性内部集合
                List<Map<String, Object>> innerList = new ArrayList<>();
                Map<String, Object> innerMap = new HashMap<>();
                innerMap.put("attrId", attributeValueDTO.getAttrId());
                innerMap.put("attrValueId", attributeValueDTO.getId());
                innerMap.put("attrValue", attributeValueDTO.getAttrValue());
                innerList.add(innerMap);
                // 添加到外部mapList中
                Map<String, Object> map = new HashMap<>();
                map.put("name", attrName);
                map.put("values", innerList);
                mapList.add(map);
            } else {
                for (int j = 0; j < mapList.size(); j++) {
                    if (attrName.equals(mapList.get(j).get("name"))) {
                        // values属性内部集合
                        Map<String, Object> innerMap = new HashMap<>();
                        innerMap.put("attrId", attributeValueDTO.getAttrId());
                        innerMap.put("attrValueId", attributeValueDTO.getId());
                        innerMap.put("attrValue", attributeValueDTO.getAttrValue());
                        ((List) (mapList.get(j).get("values"))).add(innerMap);
                        break;
                    }
                }
            }
        }
        return mapList;
    }

    @Override
    public boolean saveBrandByCategoryDTO(CategoryBrandDTO categoryBrandDTO) {
        Date date = new Date();
        categoryBrandDTO.setDate(date);
        attributeMapper.insertBrand(categoryBrandDTO);
        Long brandId = categoryBrandDTO.getId();
        int row = 0;
        if (brandId != null && brandId != 0) {
            row = attributeMapper.insertCatrgory2Brand(brandId, categoryBrandDTO.getCategory2Id(), date);
        }
        return row > 0;
    }

    @Override
    public boolean saveAttrName(String attrName, Long category2Id) {
        Date date = new Date();
        int row = attributeMapper.insertAttrName(attrName, category2Id, date);
        return row > 0;
    }

    @Override
    public String getAttrNameById(Long attrId) {
        return attributeMapper.getAttrNameById(attrId);
    }
}
