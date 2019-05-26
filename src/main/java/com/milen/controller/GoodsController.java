package com.milen.controller;


import com.milen.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping("/goods/{spuId}")
    public String goods(@PathVariable(value = "spuId",required = false) Long spuId, Model model) {
        Map<String, Object> goodsInfoVOList = goodsService.getGoodsInfoBySPUId(spuId);
        model.addAttribute("goodsInfoList", goodsInfoVOList);
        return "goods";
    }
}
