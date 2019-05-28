package com.milen.controller;


import com.milen.model.dto.TradeOrderDTO;
import com.milen.model.po.User;
import com.milen.model.vo.R;
import com.milen.service.ShopCartService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.awt.*;

@RestController
@RequestMapping("/shop-cart")
public class ShopCartController {

    @Autowired
    ShopCartService shopCartService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public R addShopCart(@RequestBody TradeOrderDTO tradeOrderDTO, HttpSession session) {
        // 检验用户登录状态
        User loginUser = (User)session.getAttribute("loginUser");
        if (loginUser == null) {
            return R.error(400, "请先登录!");
        }
        boolean isSaved = shopCartService.addShopCart(tradeOrderDTO, loginUser.getId());
        if (isSaved) {
            return R.ok(200, "添加购物车成功!");
        }
        return R.error(401, "添加购物车失败!");
    }

    @RequestMapping(value = "/buy",method = RequestMethod.POST)
    public R buyShopCartGoods(@RequestParam("shopCartId") String shopCartId, HttpSession session) {
        User loginUser = (User)session.getAttribute("loginUser");
        boolean isBought = shopCartService.buyShopCartGoods(shopCartId, loginUser.getId());
        if (isBought) {
            return R.ok(200, "购买成功!");
        }
        return R.error(400, "购买失败!");
    }
}
