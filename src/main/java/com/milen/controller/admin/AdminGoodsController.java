package com.milen.controller.admin;

import com.milen.model.vo.GoodsCategoryVO;
import com.milen.service.AttributeService;
import com.milen.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/goods")
public class AdminGoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private AttributeService attributeService;

    @RequestMapping("/category")
    public String category(Model model) {
        GoodsCategoryVO goodsCategoryVO = goodsService.listCategoryAndBrand();
        model.addAttribute("goodsCategory", goodsCategoryVO);
        return "admin";
    }

    @RequestMapping("/attribute/{id}")
    @ResponseBody
    public List<Map<String, Object>> attribute(@PathVariable("id") Long id) {
        List<Map<String, Object>> mapList = attributeService.getAttributeIdsByCategory2(id);
        System.out.println(mapList);
        return mapList;
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
