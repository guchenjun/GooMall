package com.milen.controller;

import com.milen.constant.ResultConstant;
import com.milen.model.po.Shop;
import com.milen.model.po.User;
import com.milen.model.vo.GoodsCategoryVO;
import com.milen.model.vo.R;
import com.milen.model.vo.ReleaseGoodsVO;
import com.milen.service.ApplyShopRecordService;
import com.milen.service.GoodsService;
import com.milen.service.ShopService;
import com.milen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;
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
    GoodsService goodsService;

    @Autowired
    ApplyShopRecordService applyShopRecordService;

    @RequestMapping(value = "/open-shop", method = RequestMethod.GET)
    public String openShop() {
        return "open-shop";
    }

    @RequestMapping(value = "/apply-shop", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public R applyShop(@RequestBody Shop shop, HttpSession session) {
        User currentUser = (User) session.getAttribute("loginUser");
        Long userId = currentUser.getId();
        shop.setUserId(userId);
        try {
            boolean shopExisted = shopService.getShopByUserId(userId);
            if (shopExisted) {
                return R.error(ResultConstant.APPLY_SHOP_EXIST, ResultConstant.APPLY_SHOP_EXIST_MSG);
            }
            // 储存店铺信息
            Long shopId = shopService.saveShop(shop);
            if (shopId != 0) {
                // 储存申请店铺记录，供管理员审核
                boolean isSaved = applyShopRecordService.saveApplyShopRecord(userId, shopId);
                if (isSaved) {
                    return R.ok(ResultConstant.APPLY_SHOP_SUCCESS, ResultConstant.APPLY_SHOP_SUCCESS_MSG);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return R.error(ResultConstant.APPLY_SHOP_FAILURE, ResultConstant.APPLY_SHOP_FAILURE_MSG);
    }

    @RequestMapping(value = "/release", method = RequestMethod.GET)
    public String release(Model model) {
        GoodsCategoryVO goodsCategoryVO = goodsService.listCategoryAndBrand();
        model.addAttribute("goodsCategory", goodsCategoryVO);
        return "seller-space";
    }

    @RequestMapping(value = "/release-goods", method = RequestMethod.POST)
    @ResponseBody
    public R releaseGoods(@RequestBody ReleaseGoodsVO releaseGoodsVO, HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        Long shopId = shopService.getShopIdByUserId(user.getId());
        releaseGoodsVO.setShopId(shopId);
        boolean isSaved = goodsService.saveSPU(releaseGoodsVO);
        if (isSaved) {
            return R.ok(200, "添加商品成功!");
        }
        return R.error(400, "添加商品失败!");
    }

    @RequestMapping(value = "/manage", method = RequestMethod.GET)
    public String goods() {

        return "seller-space";
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String order() {

        return "seller-space";
    }


}

