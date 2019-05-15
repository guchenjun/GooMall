package com.milen.service;

import com.milen.model.po.Shop;

public interface ShopService {

    Long saveShop(Shop shop);

    boolean getShopByUserId(Long userId);

    Long getShopIdByUserId(Long id);
}
