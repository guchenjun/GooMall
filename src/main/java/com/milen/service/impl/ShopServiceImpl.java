package com.milen.service.impl;


import com.milen.mapper.ShopMapper;
import com.milen.model.dto.CategoryDescriptionDTO;
import com.milen.model.po.SPU;
import com.milen.model.po.Shop;
import com.milen.model.vo.SPUVO;
import com.milen.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("shopService")
public class ShopServiceImpl implements ShopService {

    @Autowired
    ShopMapper shopMapper;

    @Override
    public Long saveShop(Shop shop) {
        Date date = new Date();
        shop.setGmtCreate(date);
        shop.setGmtModified(date);
        shop.setShopScore(new BigDecimal(5));
        shop.setShopAccount(new BigDecimal(0));
        shop.setShopStatus(false);
        Long row = shopMapper.saveShop(shop);
        return row;
    }

    @Override
    public boolean getShopByUserId(Long userId) {
        int row = shopMapper.getShopCountByUserId(userId);
        return row > 0;
    }

    @Override
    public Long getShopIdByUserId(Long id) {
        return shopMapper.getShopIdByUserId(id);
    }

    @Override
    public List<SPUVO> listSPU(Long shopId) {
        List<SPU> SPUList = shopMapper.listSPU(shopId);
        List<SPUVO> SPUVOList = new ArrayList<>();
        for (int i = 0; i < SPUList.size(); i++) {
            SPU spu = SPUList.get(i);
            CategoryDescriptionDTO categoryDescriptionDTO = shopMapper.getCategoryDescription(spu.getCategory1Id(), spu.getCategory2Id(), spu.getBrandId());
            String cat1Name = categoryDescriptionDTO.getCategory1Name();
            String cat2Name = categoryDescriptionDTO.getCategory2Name();
            String brandName = categoryDescriptionDTO.getBrandName();
            SPUVO spuVO = new SPUVO(spu, cat1Name + " > " + cat2Name + " > " + brandName);
            SPUVOList.add(spuVO);
        }
        return SPUVOList;
    }
}
