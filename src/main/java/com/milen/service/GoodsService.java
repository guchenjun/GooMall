package com.milen.service;

import com.milen.model.dto.SKUDTO;
import com.milen.model.po.SKU;
import com.milen.model.po.SPU;
import com.milen.model.vo.*;

import java.util.List;
import java.util.Map;

public interface GoodsService {

    GoodsCategoryVO listCategoryAndBrand();

    boolean saveSPU(ReleaseGoodsVO releaseGoodsVO);

    SPUVO getSPUById(Long spuId);

    Long saveSKU(Long spuId, SKUDTO skuDTO);

    void saveSKUImage(Long skuId, List<String> skuImages);

    void saveSKUAttrValue(Long spuId, Long skuId, List<Long> attributes);

    List<GoodsVO> listSPUByGoodsName(String goodsName);

    List<GoodsVO> listSPUByCategory1Id(Long id);

    List<GoodsVO> listSPUByCategory2Id(Long id);

    Map<String, Object> getGoodsInfoBySPUId(Long spuId);

    List<SKUVO> listSKUBySPUId(Long spuId);
}
