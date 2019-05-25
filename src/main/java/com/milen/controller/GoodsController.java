package com.milen.controller;


import com.milen.model.vo.GoodsInfoVO;
import com.milen.model.vo.SKUVO;
import com.milen.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping("/goods/{spuId}")
    public String goods(@PathVariable("spuId") Long spuId) {
        List<GoodsInfoVO> goodsInfoVOList = goodsService.getGoodsInfoBySPUId(spuId);
//        List<SKUVO> SKUVOList = goodsService.listSKUBySPUId(spuId);
        return null;
    }
}
