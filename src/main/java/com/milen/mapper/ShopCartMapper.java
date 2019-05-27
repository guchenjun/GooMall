package com.milen.mapper;

import com.milen.model.dto.ShopCartDTO;
import com.milen.model.dto.TradeOrderDTO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ShopCartMapper {

    int insertShopCart(@Param("tradeOrderDTO") TradeOrderDTO tradeOrderDTO, @Param("userId") Long id, @Param("date") Date date);

    List<ShopCartDTO> listShopCartByUserId(@Param("userId") Long id);
}
