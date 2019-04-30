package com.milen.controller;

import com.milen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(HttpSession session, Model model) {
        Object loginTip = session.getAttribute("loginTip");
        if (loginTip != null && (Boolean) loginTip == true) {
            model.addAttribute("loginTip", "请先登录!");
            session.removeAttribute("loginTip");
        }
        return "index";
    }

}
