package com.milen.controller;


import com.milen.model.dto.TradeOrderDTO;
import com.milen.model.po.User;
import com.milen.model.vo.R;
import com.milen.service.GoodsService;
import com.milen.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/trade")
public class TradeController {

    @Autowired
    TradeService tradeService;

    @Autowired
    GoodsService goodsService;

    @RequestMapping("")
    @ResponseBody
    public R tradeOrder(@RequestBody TradeOrderDTO tradeOrderDTO, HttpSession session) {
        // 检验用户登录状态
        User loginUser = (User)session.getAttribute("loginUser");
        if (loginUser == null) {
            return R.error(402, "请先登录!");
        }
        // 查询库存和用户购买数量
        Long skuStock = goodsService.getSkuStockBySkuId(tradeOrderDTO.getSkuId());
        if (skuStock < tradeOrderDTO.getAmount()) {
            return R.error(401, "商品库存不足!");
        }
        // 添加用户订单记录
        boolean isSaved = tradeService.saveTradeOrder(tradeOrderDTO, loginUser);
        boolean isUpdated = tradeService.updateSkuStockBySkuId(tradeOrderDTO.getSkuId(), skuStock, tradeOrderDTO.getAmount());
        if (!isUpdated) {
            return R.error(400, "库存不足");
        }
        if (!isSaved) {
            return R.error(400, "购买失败!");
        }
        return R.ok(200, "购买商品成功!");
    }
}
