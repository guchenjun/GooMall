package com.milen.controller.admin;


import com.milen.model.vo.BrandCategoryVO;
import com.milen.model.vo.GoodsCategoryVO;
import com.milen.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/goods")
public class AdminGoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/category")
    public String category(Model model) {
        GoodsCategoryVO goodsCategoryVO = goodsService.listCategoryAndBrand();
        model.addAttribute("goodsCategory", goodsCategoryVO);
        return "admin";
    }

    @RequestMapping("/spu")
    public String spu() {
        return "admin";
    }

    @RequestMapping("/sku")
    public String sku() {
        return "admin";
    }
}
