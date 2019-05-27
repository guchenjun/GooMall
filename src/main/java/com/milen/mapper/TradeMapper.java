package com.milen.mapper;

import com.milen.model.dto.TradeOrderDTO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TradeMapper {

    int insertTradeOrder(@Param("tradeOrderDTO") TradeOrderDTO tradeOrderDTO, @Param("userId") Long id, @Param("date")Date date);

    List<TradeOrderDTO> listTradeOrderByUserId(@Param("userId") Long id);
}
