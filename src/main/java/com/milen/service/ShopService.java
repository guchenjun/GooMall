package com.milen.service;

import com.milen.model.po.Shop;
import com.milen.model.vo.SPUVO;

import java.util.List;

public interface ShopService {

    Long saveShop(Shop shop);

    boolean getShopByUserId(Long userId);

    Long getShopIdByUserId(Long id);

    List<SPUVO> listSPU(Long shopId);
}
