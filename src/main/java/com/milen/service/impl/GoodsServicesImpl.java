package com.milen.service.impl;

import com.milen.mapper.AttributeMapper;
import com.milen.mapper.GoodsMapper;
import com.milen.mapper.ShopMapper;
import com.milen.mapper.UserMapper;
import com.milen.model.dto.AttrAndAttrValueDTO;
import com.milen.model.dto.CategoryDescriptionDTO;
import com.milen.model.dto.SKUDTO;
import com.milen.model.po.*;
import com.milen.model.vo.*;
import com.milen.service.GoodsService;
import com.milen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;


@Service("goodsService")
public class GoodsServicesImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private ShopMapper shopMapper;

    @Autowired
    AttributeMapper attributeMapper;

    @Autowired
    UserMapper userMapper;

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
            String shopName = shopMapper.getShopNameById(spu.getShopId());
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
            String shopName = shopMapper.getShopNameById(spu.getShopId());
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
            String shopName = shopMapper.getShopNameById(spu.getShopId());
            BigDecimal price = goodsMapper.getFirstSKUBySPUId(spu.getId());
            GoodsVO goodsVO = new GoodsVO(spu);
            goodsVO.setShopName(shopName);
            goodsVO.setPrice(price);
            goodsVOList.add(goodsVO);
        }
        return goodsVOList;
    }

    @Override
    public Map<String, Object> getGoodsInfoBySPUId(Long spuId) {
        // 结果声明
        Map<String, Object> resultMap = new HashMap<>();
        // 属性字段
        List<Long> attrIdList = attributeMapper.listAttrIdBySpuId(spuId);
        Map<String, Object> attrField = new HashMap<>();
        attrField.put("num", attrIdList.size());
        List<Map<String, Object>> attrNameIdList = new ArrayList<>();
        List<Map<String, Object>> attrValueIdList = new ArrayList<>();
        for (int i = 0; i < attrIdList.size(); i++) {
            Long attrId = attrIdList.get(i);
            String attrName = attributeMapper.getAttrNameById(attrId);
            Map<String, Object> innerAttrNameMap = new HashMap<>();
            innerAttrNameMap.put("id", attrId);
            innerAttrNameMap.put("name", attrName);
            attrNameIdList.add(innerAttrNameMap);

            List<AttributeValue> attributeValueList = attributeMapper.listAttrValueByAttrId(attrId);
            Set<Long> set = new HashSet<>();
            for (int j = 0; j < attributeValueList.size(); j++) {
                Map<String, Object> innerAttrValueMap = new HashMap<>();
                AttributeValue attributeValue = attributeValueList.get(j);
                if (!set.add(attributeValue.getId())) {
                    continue;
                }
                innerAttrValueMap.put("valueId", attributeValue.getId());
                innerAttrValueMap.put("attrId", attributeValue.getAttrId());
                innerAttrValueMap.put("value", attributeValue.getAttrValue());
                attrValueIdList.add(innerAttrValueMap);
            }
        }
        attrField.put("attrNames", attrNameIdList);
        attrField.put("attrValues", attrValueIdList);
        resultMap.put("attr", attrField);

        // 库存信息
        List<Map<String, Object>> skuDataField = new ArrayList<>();
        List<SKU> skuList = goodsMapper.listSKUBySPUId(spuId);
        for (int i = 0; i < skuList.size(); i++) {
            SKU sku = skuList.get(i);
            List<String> imageList = goodsMapper.listSKUImagesBySKUId(sku.getId());
            SKUVO skuvo = new SKUVO(sku, imageList);
            List<Long> attrValueList = attributeMapper.listAttrValueIdBySkuId(sku.getId());
            Map<String, Object> innerMap = new HashMap<>();
            innerMap.put("sku", skuvo);
            innerMap.put("attrValueId", attrValueList);
            skuDataField.add(innerMap);
        }
        resultMap.put("skuData", skuDataField);
        System.out.println(resultMap);
        return resultMap;
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

    @Override
    public Long getSkuStockBySkuId(Long skuId) {
        Long skuStock = goodsMapper.getSkuStockBySkuId(skuId);
        return skuStock;
    }

    @Transactional
    @Override
    public boolean updateGoodsStatusById(Long spuId) {
        goodsMapper.updateGoodsGmtModified(spuId, new Date());
        Long isOn = goodsMapper.getGoodsStatusById(spuId);
        if (isOn == 0) {
            goodsMapper.updateGoodsStatusOnById(spuId);
            return true;
        } else {
            goodsMapper.updateGoodsStatusOffById(spuId);
            return false;
        }
    }

    @Override
    public Shop getShopBySpuId(Long spuId) {
        Shop shop = goodsMapper.getShopBySpuId(spuId);
        return shop;
    }

    @Override
    public boolean saveGoodsComment(Long spuId, String content, Long id) {
        Date date = new Date();
        int row = goodsMapper.insertGoodsComment(spuId, content, id, date);
        return row > 0;
    }

    @Override
    public List<CommentVO> listCommentsBySpuId(Long spuId) {
        List<Comment> commentList = goodsMapper.listCommentsBySpuId(spuId);
        List<CommentVO> commentVOList = new ArrayList<>();
        for (int i = 0; i < commentList.size(); i++) {
            Comment comment = commentList.get(i);
            String username = userMapper.getUsernameById(comment.getUserId());
            CommentVO commentVO = new CommentVO();
            commentVO.setUsername(username);
            commentVO.setContent(comment.getContent());
            commentVO.setDate(comment.getGmtCreate());
            commentVOList.add(commentVO);
        }
        return commentVOList;
    }

    @Override
    public String getSpuImageById(Long spuId) {
        return goodsMapper.getSpuImageById(spuId);
    }

}
