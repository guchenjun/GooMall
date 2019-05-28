package com.milen.controller;


import com.milen.model.dto.TradeOrderDTO;
import com.milen.model.po.User;
import com.milen.model.vo.ShopCartVO;
import com.milen.model.vo.TradeOrderVO;
import com.milen.service.ShopCartService;
import com.milen.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    TradeService tradeService;

    @Autowired
    ShopCartService shopCartService;

    @RequestMapping("/info")
    public String memberInfo() {
        return "member";
    }

    @RequestMapping("/order")
    public String memberOrder(HttpSession session, Model model) {
        User user = (User)session.getAttribute("loginUser");
        List<TradeOrderVO> tradeOrderVOList  = tradeService.listTradeOrderByUserId(user.getId());
        model.addAttribute("tradeOrderList", tradeOrderVOList);
        return "member";
    }

    @RequestMapping("/cart")
    public String memberCart(HttpSession session, Model model) {
        User user = (User)session.getAttribute("loginUser");
        List<ShopCartVO> shopCartVOList = shopCartService.listShopCartByUserId(user.getId());
        model.addAttribute("shopCartList", shopCartVOList);
        // 2019年5月27日 23:51:42
        // member Line 188，弹出层付款确认；上下架商品接口

        return "member";


    }

    @RequestMapping("/favorites")
    public String memberFavorites(HttpSession session) {
        User user = (User)session.getAttribute("loginUser");
        return "member";
    }

}
