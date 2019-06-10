package com.milen.controller.admin;


import com.milen.model.po.Ad;
import com.milen.model.vo.R;
import com.milen.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminAdController {

    @Autowired
    AdService adService;

    @RequestMapping(value = "/advertisement", method = RequestMethod.GET)
    public String advertisement(Model model) {
        List<Ad> adList = adService.listAd();
        model.addAttribute("ad0", adList.get(0));
        return "admin";
    }

    @RequestMapping(value = "/advertisement/add", method = RequestMethod.POST)
    @ResponseBody
    public R addAd(@RequestBody Ad ad) {
        try {
            adService.updateAd(ad);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(400, "更新广告失败!");
        }
        return R.ok(200, "更新广告成功!");
    }

    @RequestMapping(value = "/advertisement/toggle-status/{id}", method = RequestMethod.GET)
    @ResponseBody
    public R toggleStatus(@PathVariable("id") Long id) {
        try {
            adService.updateAdStatusById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(400, "更新状态失败");
        }
        return R.ok(200, "广告状态切换成功!");
    }
}
