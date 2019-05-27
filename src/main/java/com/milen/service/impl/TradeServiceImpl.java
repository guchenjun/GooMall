package com.milen.service.impl;

import com.milen.mapper.GoodsMapper;
import com.milen.mapper.TradeMapper;
import com.milen.model.dto.TradeOrderDTO;
import com.milen.model.po.User;
import com.milen.model.vo.TradeOrderVO;
import com.milen.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service("tradeService")
public class TradeServiceImpl implements TradeService {

    @Autowired
    TradeMapper tradeMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Transactional
    @Override
    public boolean saveTradeOrder(TradeOrderDTO tradeOrderDTO, User loginUser) {
        Date date = new Date();
        int row = tradeMapper.insertTradeOrder(tradeOrderDTO, loginUser.getId(), date);
        return row > 0;
    }

    @Override
    public List<TradeOrderVO> listTradeOrderByUserId(Long id) {
        List<TradeOrderDTO> tradeOrderDTOList = tradeMapper.listTradeOrderByUserId(id);
        List<TradeOrderVO> tradeOrderVOList = new ArrayList<>();
        for (int i = 0; i < tradeOrderDTOList.size(); i++) {
            TradeOrderDTO tradeOrderDTO = tradeOrderDTOList.get(i);
            TradeOrderVO tradeOrderVO = new TradeOrderVO(tradeOrderDTO);
            tradeOrderVO.setTotalPrice(tradeOrderDTO.getPrice().multiply(BigDecimal.valueOf(tradeOrderDTO.getAmount())));
            tradeOrderVOList.add(tradeOrderVO);
        }
        return tradeOrderVOList;
    }

    @Override
    public boolean updateSkuStockBySkuId(Long skuId, Long skuStock, Long amount) {
        int row = goodsMapper.updateSkuStockBySkuId(skuId, skuStock, amount);
        return row > 0;
    }
}
