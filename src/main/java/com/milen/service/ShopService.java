package com.milen.service;

import com.milen.pojo.po.Shop;

public interface ShopService {

    Long saveShop(Shop shop);

    boolean getShopByUserId(Long userId);
}
