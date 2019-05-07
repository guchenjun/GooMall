package com.milen.mapper;

import com.milen.model.po.AttributeValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttributeMapper {

    List<Long> getAttributeIdsByCategory2(@Param("id") Long id);

    List<AttributeValue> getAttributeNameAndValueByIds(@Param("idList") List<Long> idList);
}
