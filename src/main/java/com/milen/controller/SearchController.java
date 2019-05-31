package com.milen.controller;


import com.milen.model.po.SPU;
import com.milen.model.vo.GoodsVO;
import com.milen.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("")
    public String search(@RequestParam(value = "q", required = false) String goodsName,
                         @RequestParam(value = "category1", required = false) Long category1Id,
                         @RequestParam(value = "category2", required = false) Long category2Id,
                         Model model) {
        List<GoodsVO> goodsVOList = new ArrayList<>();
        if (goodsName != null) {
            // 根据商品名称搜索商品SPU列表
            goodsVOList = goodsService.listSPUByGoodsName(goodsName);
        } else if (category1Id != null) {
            // 根据一级分类搜索商品SPU列表
            goodsVOList = goodsService.listSPUByCategory1Id(category1Id);
        } else if (category2Id != null) {
            goodsVOList = goodsService.listSPUByCategory2Id(category2Id);
        }
        model.addAttribute("goodsList", goodsVOList);
        return "search";
    }

//    // 根据一级分类搜索商品SPU列表
//    @RequestMapping("")
//    public String category1(@RequestParam(value = "category1", required = false) Long category1Id, Model model) {
//        List<GoodsVO> goodsVOList = goodsService.listSPUByCategory1Id(category1Id);
//        model.addAttribute("goodsList", goodsVOList);
//        return "search";
//    }

    // 根据二级分类搜索商品SPU列表
    @RequestMapping("/category2/{id}")
    public String category2(@PathVariable("id") Long id) {
        List<GoodsVO> goodsVOList = goodsService.listSPUByCategory2Id(id);
        return null;
    }
}
