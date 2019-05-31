package com.milen.mapper;

import com.milen.model.dto.AttrAndAttrValueDTO;
import com.milen.model.dto.SKUDTO;
import com.milen.model.po.*;
import com.milen.model.vo.ReleaseGoodsVO;
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

    Long getSkuStockBySkuId(@Param("skuId") Long skuId);

    int updateSkuStockBySkuId(@Param("skuId") Long skuId, @Param("skuStock") Long skuStock, @Param("amount") Long amount);

    Long getGoodsStatusById(@Param("spuId") Long spuId);

    void updateGoodsStatusOnById(@Param("spuId") Long spuId);

    void updateGoodsStatusOffById(@Param("spuId") Long spuId);

    Shop getShopBySpuId(@Param("spuId") Long spuId);

    int insertGoodsComment(@Param("spuId") Long spuId,@Param("content") String content,@Param("userId") Long id,@Param("date") Date date);

    List<Comment> listCommentsBySpuId(@Param("spuId") Long spuId);

    String getSpuImageById(@Param("spuId") Long spuId);
}
