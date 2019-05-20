package com.milen.service.impl;

import com.milen.mapper.AttributeMapper;
import com.milen.mapper.GoodsMapper;
import com.milen.mapper.ShopMapper;
import com.milen.model.dto.AttrAndAttrValueDTO;
import com.milen.model.dto.CategoryDescriptionDTO;
import com.milen.model.dto.SKUDTO;
import com.milen.model.po.*;
import com.milen.model.vo.BrandCategoryVO;
import com.milen.model.vo.GoodsCategoryVO;
import com.milen.model.vo.ReleaseGoodsVO;
import com.milen.model.vo.SPUVO;
import com.milen.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
