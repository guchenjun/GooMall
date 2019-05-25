package com.milen.mapper;

import com.milen.model.dto.AttrAndAttrValueDTO;
import com.milen.model.dto.SKUDTO;
import com.milen.model.po.*;
import com.milen.model.vo.ReleaseGoodsVO;
import com.milen.model.vo.SPUVO;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface GoodsMapper {
    List<Category1> listCategory1();

    List<Category2> listCategory2();

    List<BrandCategory> listBrandAndCategory2();

    List<Brand> listBrand();

    int insertSPU(ReleaseGoodsVO releaseGoodsVO);

    SPU getSPUById(@Param("spuId") Long spuId);

    Long getCategory2IdBySPUId(@Param("spuId") Long spuId);

    long insertSKU(@Param("spuId") Long spuId, @Param("skuDTO") SKUDTO skuDTO, @Param("date") Date date);

    void insertSKUImage(@Param("skuId") Long skuId, @Param("skuImages") List<String> skuImages, @Param("date") Date date);

    void insertSKUAttrValue(@Param("spuId") Long spuId, @Param("skuId") Long skuId,@Param("attrAndAttrValueDTOList") List<AttrAndAttrValueDTO> attrAndAttrValueDTOList, @Param("date") Date date);

    List<SPU> listSPUByGoodsName(@Param("goodsName") String goodsName);

    List<SPU> listSPUByCategory1Id(@Param("id") Long id);

    List<SPU> listSPUByCategory2Id(@Param("id") Long id);

    List<SKU> listSKUBySPUId(@Param("spuId") Long spuId);

    List<String> listSKUImagesBySKUId(@Param("id") Long id);

    BigDecimal getFirstSKUBySPUId(@Param("id") Long id);
}
