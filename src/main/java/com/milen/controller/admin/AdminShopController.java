package com.milen.controller.admin;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.milen.constant.ResultConstant;
import com.milen.model.po.Admin;
import com.milen.model.po.Shop;
import com.milen.model.vo.ApplyShopRecordVO;
import com.milen.model.vo.R;
import com.milen.model.vo.ShopVO;
import com.milen.service.AdminShopService;
import com.milen.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.milen.constant.ResultConstant.MORE_SHOP_INFO_FAILURE_MSG;

@Controller
@RequestMapping("/admin/shop")
public class AdminShopController {

    @Autowired
    private AdminShopService adminShopService;

    @Autowired
    private SellerService sellerService;

    // 商铺审核功能

    @RequestMapping(value = {"/review/{pageNum}", "/review"}, method = RequestMethod.GET)
    public String review(@PathVariable(value = "pageNum", required = false) Integer pageNum, Model model) {
        // 设置当前页和每页大小
        if (pageNum == null) {
            pageNum = 1;
        }
        int pageSize = 3;
        Page<ApplyShopRecordVO> page = PageHelper.startPage(pageNum, pageSize);
        List<ApplyShopRecordVO> recordListVO = adminShopService.listApplyShopRecord();
        PageInfo<ApplyShopRecordVO> pageVO = new PageInfo<>(page.getResult());
        model.addAttribute("recordList", recordListVO);
        model.addAttribute("page", pageVO);
        return "admin";
    }

    @RequestMapping(value = "/review/agree/{recordId}", method = RequestMethod.GET)
    public String agree(@PathVariable("recordId") int recordId, HttpSession session, HttpServletRequest request,
                        RedirectAttributesModelMap modelMap) {
        Admin loginAdmin = (Admin) session.getAttribute("loginAdmin");
        if (loginAdmin != null && loginAdmin.getId() != null) {
            int adminId = loginAdmin.getId();
            if (adminShopService.updateAgreeShopRecord(recordId, adminId)) {
                modelMap.addFlashAttribute("sucMsg", "审核已通过!");
            } else {
                modelMap.addFlashAttribute("errMsg", "审核失败!");
            }
        }
        return "redirect:/admin/shop/review";
    }


    // 商铺信息

    @RequestMapping(value = {"/info", "/info/{pageNum}"}, method = RequestMethod.GET)
    public String info(@PathVariable(value = "pageNum", required = false) Integer pageNum, Model model) {
        if (pageNum == null) {
            pageNum = 1;
        }
        int pageSize = 3;
        Page<ShopVO> page = PageHelper.startPage(pageNum, pageSize);
        List<ShopVO> shopListVO = adminShopService.listShopInfo();
        PageInfo<ShopVO> pageVO = new PageInfo<>(page.getResult());
        model.addAttribute("shopList", shopListVO);
        model.addAttribute("page", pageVO);
        return "admin";
    }

    @RequestMapping(value = "/info/more/{shopId}", method = RequestMethod.GET)
    @ResponseBody
    public R moreInfo(@PathVariable("shopId") int shopId) {
        Shop shop = adminShopService.getShopById(shopId);
        if (shop != null) {
            String status = "暂停经营";
            Boolean shopStatus = shop.getShopStatus();
            if (shopStatus) {
                status = "正常经营";
            }
            Long userId = shop.getUserId();
            String sellerName = sellerService.getSellerNameById(userId);
            ShopVO shopVO = new ShopVO(shop, status, sellerName);
            return R.ok(ResultConstant.MORE_SHOP_INFO_SUCCESS, "ok", shopVO);
        }
        return R.error(ResultConstant.MORE_SHOP_INFO_FAILURE, MORE_SHOP_INFO_FAILURE_MSG, null);
    }


}
