package com.milen.mapper;

import com.milen.model.dto.CategoryDescriptionDTO;
import com.milen.model.po.SPU;
import com.milen.model.po.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopMapper {
    Long saveShop(Shop shop);

    int getShopCountByUserId(@Param("userId") Long userId);

    Long getShopIdByUserId(@Param("userId") Long id);

    List<SPU> listSPU(@Param("shopId") Long shopId);

    CategoryDescriptionDTO getCategoryDescription(@Param("category1Id") Long category1Id, @Param("category2Id") Long category2Id, @Param("brandId") Long brandId);

    String getShopNameById(@Param("id") Long id);

    List<SPU> listAllSPU();
}
