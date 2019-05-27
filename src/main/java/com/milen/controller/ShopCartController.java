package com.milen.controller;


import com.milen.model.dto.TradeOrderDTO;
import com.milen.model.po.User;
import com.milen.model.vo.R;
import com.milen.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

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
}
