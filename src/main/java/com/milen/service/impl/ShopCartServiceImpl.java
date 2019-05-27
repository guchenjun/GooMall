package com.milen.service.impl;

import com.milen.mapper.ShopCartMapper;
import com.milen.model.dto.ShopCartDTO;
import com.milen.model.dto.TradeOrderDTO;
import com.milen.model.vo.ShopCartVO;
import com.milen.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service("shopCartService")
public class ShopCartServiceImpl implements ShopCartService {

    @Autowired
    ShopCartMapper shopCartMapper;

    @Override
    public boolean addShopCart(TradeOrderDTO tradeOrderDTO, Long id) {
        Date date = new Date();
        int row = shopCartMapper.insertShopCart(tradeOrderDTO, id, date);
        return row > 0;
    }

    @Override
    public List<ShopCartVO> listShopCartByUserId(Long id) {
        List<ShopCartDTO> shopCartDTOList= shopCartMapper.listShopCartByUserId(id);
        List<ShopCartVO> tradeOrderVOList = new ArrayList<>();
        for (int i = 0; i < shopCartDTOList.size(); i++) {
            ShopCartDTO shopCartDTO = shopCartDTOList.get(i);
            ShopCartVO tradeOrderVO = new ShopCartVO(shopCartDTO);
            tradeOrderVO.setTotalPrice(shopCartDTO.getPrice().multiply(BigDecimal.valueOf(shopCartDTO.getAmount())));
            tradeOrderVOList.add(tradeOrderVO);
        }
        return tradeOrderVOList;
    }
}
