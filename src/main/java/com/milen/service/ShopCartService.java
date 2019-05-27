package com.milen.service;

import com.milen.model.dto.TradeOrderDTO;
import com.milen.model.vo.ShopCartVO;

import java.util.List;

public interface ShopCartService {

    boolean addShopCart(TradeOrderDTO tradeOrderDTO, Long id);

    List<ShopCartVO> listShopCartByUserId(Long id);
}
