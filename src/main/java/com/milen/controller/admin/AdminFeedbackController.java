package com.milen.controller.admin;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.milen.model.po.Feedback;
import com.milen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminFeedbackController {

    @Autowired
    UserService userService;

    @RequestMapping(value = {"/feedback", "/feedback/{pageNum}"}, method = RequestMethod.GET)
    public String feedback(@PathVariable(value = "pageNum", required = false) Integer pageNum,
                           Model model) {
        if (pageNum == null) {
            pageNum = 1;
        }
        int pageSize = 4;
        Page<Feedback> page = PageHelper.startPage(pageNum, pageSize);
        List<Feedback> feedbackList = userService.listFeedback();
        PageInfo<Feedback> pageVO = new PageInfo<>(page.getResult());
        model.addAttribute("feedbackList", feedbackList);
        model.addAttribute("feedBackPage", pageVO);
        return "admin";
    }
}
