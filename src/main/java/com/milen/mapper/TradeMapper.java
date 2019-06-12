package com.milen.mapper;

import com.milen.model.dto.TradeOrderDTO;
import com.milen.model.po.ShopCart;
import com.milen.model.po.TradeOrder;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TradeMapper {

    int insertTradeOrder(@Param("tradeOrderDTO") TradeOrderDTO tradeOrderDTO, @Param("userId") Long id, @Param("date")Date date);

    List<TradeOrderDTO> listTradeOrderByUserId(@Param("userId") Long id);

    int insertTradeOrderByShopCart(@Param("shopCart") ShopCart shopCart, @Param("userId") Long userId, @Param("date")Date date);

    List<TradeOrder> listTradeOrderBySellerId(@Param("sellerId") Long id);

    String getUsernameById(@Param("userId") Long userId);

    int updateSkuStockById(@Param("skuId") Long skuId);
}
