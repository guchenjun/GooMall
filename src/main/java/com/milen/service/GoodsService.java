package com.milen.service;

import com.milen.model.dto.SKUDTO;
import com.milen.model.vo.GoodsCategoryVO;
import com.milen.model.vo.ReleaseGoodsVO;
import com.milen.model.vo.SPUVO;

import java.util.List;

public interface GoodsService {

    GoodsCategoryVO listCategoryAndBrand();

    boolean saveSPU(ReleaseGoodsVO releaseGoodsVO);

    SPUVO getSPUById(Long spuId);

    Long saveSKU(Long spuId, SKUDTO skuDTO);

    void saveSKUImage(Long skuId, List<String> skuImages);

    void saveSKUAttrValue(Long spuId, Long skuId, List<Long> attributes);
}
