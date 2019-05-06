package com.milen.service.impl;


import com.milen.mapper.ShopMapper;
import com.milen.model.po.Shop;
import com.milen.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

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
}
