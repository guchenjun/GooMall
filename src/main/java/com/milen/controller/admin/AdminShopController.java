package com.milen.controller.admin;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.milen.constant.ApplicationConstant;
import com.milen.pojo.po.Admin;
import com.milen.pojo.vo.ApplyShopRecordVO;
import com.milen.service.AdminShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/shop")
public class AdminShopController {

    @Autowired
    private AdminShopService adminShopService;

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




}
