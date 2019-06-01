package com.milen.service;

import com.milen.model.dto.TradeOrderDTO;
import com.milen.model.po.User;
import com.milen.model.vo.TradeOrderSellerVO;
import com.milen.model.vo.TradeOrderVO;

import java.util.List;

public interface TradeService {
    boolean saveTradeOrder(TradeOrderDTO tradeOrderDTO, User loginUser);

    List<TradeOrderVO> listTradeOrderByUserId(Long id);

    boolean updateSkuStockBySkuId(Long skuId, Long skuStock, Long amount);

    List<TradeOrderSellerVO> listTradeOrderBySellerId(Long id);
}
