package com.milen.controller;


import com.milen.model.dto.TradeOrderDTO;
import com.milen.model.po.User;
import com.milen.model.vo.R;
import com.milen.model.vo.ShopCartVO;
import com.milen.model.vo.TradeOrderVO;
import com.milen.service.ShopCartService;
import com.milen.service.TradeService;
import com.milen.service.UserService;
import com.milen.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    TradeService tradeService;

    @Autowired
    ShopCartService shopCartService;

    @Autowired
    UserService userService;

    @RequestMapping("/info")
    public String memberInfo() {
        return "member";
    }

    @RequestMapping("/upload-head")
    @ResponseBody
    public R uploadHead(MultipartFile file, HttpSession session) {
        User user = (User)session.getAttribute("loginUser");
        String imagePath = UploadUtil.uploadHead(file);
        if (user != null &&imagePath != null && !"".equals(imagePath)) {
            boolean isUpdated = userService.updateHeadImageById(imagePath, user.getId());
            if (isUpdated) {
                user.setHeadImage(imagePath);
                session.setAttribute("loginUser", user);
                return R.ok(200, "更新成功!", imagePath);
            }
        }
        return R.error(400, "更新失败!");
    }

    @RequestMapping(value = "/change-pwd", method = RequestMethod.POST)
    @ResponseBody
    public R changePwd(HttpSession session,
                       @RequestParam("oldPwd")String oldPwd,
                       @RequestParam("newPwd")String newPwd) {
        User user = (User) session.getAttribute("loginUser");
        String oldPwdMd5 = DigestUtils.md5DigestAsHex(oldPwd.getBytes());
        String rightPwdMd5 = userService.getPasswordById(user.getId());
        if (!rightPwdMd5.equals(oldPwdMd5)) {
            return R.error(400, "原密码不正确!");
        }
        boolean isUpdated = userService.updatePasswordById(newPwd, user.getId());
        if (isUpdated) {
            return R.ok(200, "密码更新成功!");
        }
        return R.error(401, "密码更新失败!");
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
