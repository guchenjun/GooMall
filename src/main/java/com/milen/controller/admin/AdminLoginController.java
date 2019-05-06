package com.milen.controller.admin;


import com.milen.model.po.Admin;
import com.milen.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {

    @Autowired
    private AdminLoginService adminLoginService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "admin-login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        HttpSession session, Model model) {
        String loginMsg = null;
        if (!adminLoginService.getUsername(username)) {
            loginMsg = "帐号不存在!";
            model.addAttribute("loginMsg", loginMsg);
            return "admin-login";
        }
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!md5Password.equals(adminLoginService.getPasswordByUsername(username))) {
            loginMsg = "帐号或密码不正确!";
            model.addAttribute("loginMsg", loginMsg);
            return "admin-login";
        } else {
            Admin admin= adminLoginService.getAdminByUsername(username);
            session.setAttribute("loginAdmin", admin);
            return "redirect:/admin";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("loginAdmin");
        return "admin-login";
    }
}
