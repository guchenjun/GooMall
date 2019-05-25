package com.milen.service.impl;

import com.milen.mapper.AttributeMapper;
import com.milen.mapper.GoodsMapper;
import com.milen.mapper.ShopMapper;
import com.milen.model.dto.AttrAndAttrValueDTO;
import com.milen.model.dto.CategoryDescriptionDTO;
import com.milen.model.dto.SKUDTO;
import com.milen.model.po.*;
import com.milen.model.vo.*;
import com.milen.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service("goodsService")
public class GoodsServicesImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private ShopMapper shopMapper;

    @Autowired
    AttributeMapper attributeMapper;

    @Override
    public GoodsCategoryVO listCategoryAndBrand() {
        List<Category1> category1List = goodsMapper.listCategory1();
        List<Category2> category2List = goodsMapper.listCategory2();
        List<Brand> brandList = goodsMapper.listBrand();
        List<BrandCategory> brandCategoryList = goodsMapper.listBrandAndCategory2();
        GoodsCategoryVO goodsCategoryVO = new GoodsCategoryVO(category1List, category2List, brandList, brandCategoryList);
        return goodsCategoryVO;
    }

    @Override
    public boolean saveSPU(ReleaseGoodsVO releaseGoodsVO) {
        int row = goodsMapper.insertSPU(releaseGoodsVO);
        return row > 0;
    }

    @Override
    public SPUVO getSPUById(Long spuId) {
        SPU spu = goodsMapper.getSPUById(spuId);
        CategoryDescriptionDTO categoryDescriptionDTO = shopMapper.getCategoryDescription(spu.getCategory1Id(), spu.getCategory2Id(), spu.getBrandId());
        String cat1Name = categoryDescriptionDTO.getCategory1Name();
        String cat2Name = categoryDescriptionDTO.getCategory2Name();
        String brandName = categoryDescriptionDTO.getBrandName();
        SPUVO spuVO = new SPUVO(spu, cat1Name + " > " + cat2Name + " > " + brandName);
        return spuVO;
    }

    @Override
    public Long saveSKU(Long spuId, SKUDTO skuDTO) {
        Date date = new Date();
        long id = goodsMapper.insertSKU(spuId, skuDTO, date);
        return id;
    }

    @Override
    public void saveSKUImage(Long skuId, List<String> skuImages) {
        Date date = new Date();
        goodsMapper.insertSKUImage(skuId, skuImages, date);
    }

    @Override
    public void saveSKUAttrValue(Long spuId, Long skuId, List<Long> attributes) {
        Date date = new Date();
        List<AttrAndAttrValueDTO> attrAndAttrValueDTOList = attributeMapper.listAttrAndAttrValue(attributes);
        goodsMapper.insertSKUAttrValue(spuId, skuId, attrAndAttrValueDTOList, date);
    }

    @Override
    public List<GoodsVO> listSPUByGoodsName(String goodsName) {
        List<SPU> spuList = goodsMapper.listSPUByGoodsName(goodsName);
        List<GoodsVO> goodsVOList = new ArrayList<>();
        for (SPU spu : spuList) {
            String shopName = shopMapper.getShopNameById(spu.getId());
            BigDecimal price = goodsMapper.getFirstSKUBySPUId(spu.getId());
            GoodsVO goodsVO = new GoodsVO(spu);
            goodsVO.setShopName(shopName);
            goodsVO.setPrice(price);
            goodsVOList.add(goodsVO);
        }
        return goodsVOList;
    }

    @Override
    public List<GoodsVO> listSPUByCategory1Id(Long id) {
        List<SPU> spuList = goodsMapper.listSPUByCategory1Id(id);
        List<GoodsVO> goodsVOList = new ArrayList<>();
        for (SPU spu : spuList) {
            String shopName = shopMapper.getShopNameById(spu.getId());
            BigDecimal price = goodsMapper.getFirstSKUBySPUId(spu.getId());
            GoodsVO goodsVO = new GoodsVO(spu);
            goodsVO.setShopName(shopName);
            goodsVO.setPrice(price);
            goodsVOList.add(goodsVO);
        }
        return goodsVOList;
    }

    @Override
    public List<GoodsVO> listSPUByCategory2Id(Long id) {
        List<SPU> spuList = goodsMapper.listSPUByCategory2Id(id);
        List<GoodsVO> goodsVOList = new ArrayList<>();
        for (SPU spu : spuList) {
            String shopName = shopMapper.getShopNameById(spu.getId());
            GoodsVO goodsVO = new GoodsVO(spu);
            goodsVO.setShopName(shopName);
            goodsVOList.add(goodsVO);
        }
        return goodsVOList;
    }

    @Override
    public List<GoodsInfoVO> getGoodsInfoBySPUId(Long spuId) {
//        List<SKU> skuList = goodsMapper.listSKUBySPUId(spuId);
        // 查询spu所有属性名称
//        List<Long> attrIdList = attributeMapper.listAttrIdBySPUId(spuId);
        // 查询
        return null;
    }

    @Override
    public List<SKUVO> listSKUBySPUId(Long spuId) {
        List<SKU> skuList = goodsMapper.listSKUBySPUId(spuId);
        List<SKUVO> skuvoList = new ArrayList<>();
        for (int i = 0; i < skuList.size(); i++) {
            SKU sku = skuList.get(i);
            List<String> images = goodsMapper.listSKUImagesBySKUId(sku.getId());
            SKUVO skuvo = new SKUVO(sku, images);
            skuvoList.add(skuvo);
        }
        return skuvoList;
    }

}
