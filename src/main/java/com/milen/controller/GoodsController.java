package com.milen.controller;


import com.milen.model.po.Shop;
import com.milen.model.po.User;
import com.milen.model.vo.CommentVO;
import com.milen.model.vo.R;
import com.milen.service.GoodsService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping("/goods/{spuId}")
    public String goods(@PathVariable(value = "spuId",required = false) Long spuId, Model model) {
        String goodsCover = goodsService.getSpuImageById(spuId);
        Map<String, Object> goodsInfoVOList = goodsService.getGoodsInfoBySPUId(spuId);
        Shop shop = goodsService.getShopBySpuId(spuId);
        List<CommentVO> commentVOList = goodsService.listCommentsBySpuId(spuId);
        model.addAttribute("goodsCover", goodsCover);
        model.addAttribute("goodsInfoList", goodsInfoVOList);
        model.addAttribute("shop", shop);
        model.addAttribute("commentList", commentVOList);
        return "goods";
    }

    @RequestMapping(value = "/goods/toggle-status", method = RequestMethod.POST)
    @ResponseBody
    public R toggleStatus(@RequestParam("spuId") Long spuId) {
        boolean isUpdated = goodsService.updateGoodsStatusById(spuId);
        if (isUpdated) {
            return R.ok(200, "上架商品单元成功!");
        }
        return R.error(200, "下架商品单元成功!");
    }

    @RequestMapping(value = "/goods/comment/add", method = RequestMethod.POST)
    @ResponseBody
    public R addComment(@RequestParam("spuId") Long spuId,
                        @RequestParam("content") String content,
                        HttpSession session) {
        User user = (User) session.getAttribute("loginUser");
        if (user == null) {
            return R.ok(400, "请先登录!");
        }
        boolean isSaved = goodsService.saveGoodsComment(spuId, content, user.getId());
        if (isSaved) {
            return R.ok(200, "添加评论成功!");
        }
        return R.error(400, "添加评论失败!");
    }
}
