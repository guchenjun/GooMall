package com.milen.controller;

import com.milen.constant.ResultConstant;
import com.milen.pojo.po.Shop;
import com.milen.pojo.po.User;
import com.milen.pojo.vo.ResultVO;
import com.milen.service.ApplyShopRecordService;
import com.milen.service.ShopService;
import com.milen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    UserService userService;

    @Autowired
    ShopService shopService;

    @Autowired
    ApplyShopRecordService applyShopRecordService;

    @RequestMapping(value = "/open-shop", method = RequestMethod.GET)
    public String openShop() {
        return "open-shop";
    }

    @RequestMapping(value = "/apply-shop", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public ResultVO applyShop(@RequestBody Shop shop, HttpSession session) {
        User currentUser = (User) session.getAttribute("loginUser");
///        userService.updateUserRoleById(loginUser.getId()); // 后台管理审核通过才更改角色
        Long userId = currentUser.getId();
        shop.setUserId(userId);
        try {
            boolean shopExisted = shopService.getShopByUserId(userId);
            if (shopExisted) {
                return ResultVO.error(ResultConstant.APPLY_SHOP_EXIST, ResultConstant.APPLY_SHOP_EXIST_MSG);
            }
            // 储存店铺信息
            Long shopId = shopService.saveShop(shop);
            if (shopId != 0) {
                // 储存申请店铺记录，供管理员审核
                boolean isSaved = applyShopRecordService.saveApplyShopRecord(userId, shopId);
                if (isSaved) {
                    return ResultVO.ok(ResultConstant.APPLY_SHOP_SUCCESS, ResultConstant.APPLY_SHOP_SUCCESS_MSG);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return ResultVO.error(ResultConstant.APPLY_SHOP_FAILURE, ResultConstant.APPLY_SHOP_FAILURE_MSG);
    }
}

