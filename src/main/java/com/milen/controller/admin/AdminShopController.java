package com.milen.controller.admin;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.milen.pojo.dto.ApplyShopRecordDTO;
import com.milen.pojo.vo.ApplyShopRecordVO;
import com.milen.service.AdminShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminShopController {

    @Autowired
    private AdminShopService adminShopService;

    @RequestMapping(value = "/review", method = RequestMethod.GET)
    public String review(@RequestParam(required=false,defaultValue="1") Integer pageNum,
                                              @RequestParam(required=false,defaultValue="2") Integer pageSize, Model model) {
        // 设置当前页和每页大小
        PageHelper.startPage(pageNum, pageSize);
        List<ApplyShopRecordVO> recordListVO = adminShopService.listApplyShopRecord();
        PageInfo<ApplyShopRecordVO> pageVO = new PageInfo<>(recordListVO);
        model.addAttribute("recordList", recordListVO);
        model.addAttribute("page", pageVO);
        return "admin";
    }
}
