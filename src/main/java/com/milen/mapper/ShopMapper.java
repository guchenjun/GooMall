package com.milen.mapper;

import com.milen.pojo.po.Shop;
import org.apache.ibatis.annotations.Param;

public interface ShopMapper {
    Long saveShop(Shop shop);

    int getShopCountByUserId(@Param("userId") Long userId);
}
