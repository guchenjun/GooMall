package com.milen.controller;

import com.milen.constant.ResultConstant;
import com.milen.model.dto.SKUDTO;
import com.milen.model.po.SKU;
import com.milen.model.po.SPU;
import com.milen.model.po.Shop;
import com.milen.model.po.User;
import com.milen.model.vo.*;
import com.milen.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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
    AttributeService attributeService;

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
    public String goods(Model model, HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        Long shopId = shopService.getShopIdByUserId(user.getId());
        List<SPUVO> SPUList =  shopService.listSPU(shopId);
        model.addAttribute("SPUList", SPUList);
        System.out.println(SPUList);
        return "seller-space";
    }

    @RequestMapping(value = "/manage/spu/{spuId}/sku", method = RequestMethod.GET)
    public String sku(@PathVariable("spuId") Long spuId, Model model) {
        SPUVO spuVO= goodsService.getSPUById(spuId);
        // [{name: '颜色', values: [{attrId: 1, attrValueId: 2, attrName: '白色'}, {attrId: 1, attrValueId: 3, attrName: '黑色'}]}]
        List<Map<String, Object>> attributeList = attributeService.getAttributeListBySPUId(spuId);
        List<SKUVO> SKUVOList = goodsService.listSKUBySPUId(spuId);
        model.addAttribute("SPU", spuVO);
        model.addAttribute("attributeList", attributeList);
        model.addAttribute("SKUList", SKUVOList);
        return "seller-space";
    }

    @RequestMapping(value = "/manage/spu/{spuId}/sku/add", method = RequestMethod.POST)
    @ResponseBody
    public R addSKU(@RequestBody SKUDTO skuDTO, @PathVariable("spuId") Long spuId) {
        try {
            goodsService.saveSKU(spuId, skuDTO);
            Long skuId = skuDTO.getId();
            if (skuId != 0) {
                goodsService.saveSKUImage(skuId, skuDTO.getSkuImages());
                // 下面这个报错，2019年5月20日 21:42:07
                goodsService.saveSKUAttrValue(spuId, skuId, skuDTO.getAttributes());
                return R.ok(200, "商品库存单元上传成功!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            R.ok(400,"商品库存单元上传失败!");
        }
        return R.ok(400,"商品库存单元上传失败!");
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String order() {

        return "seller-space";
    }


}

