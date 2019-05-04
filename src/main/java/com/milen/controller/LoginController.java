package com.milen.controller;


import com.milen.pojo.po.User;
import com.milen.service.UserService;
import com.milen.pojo.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public R register(@RequestBody User user) {
        String username = user.getUsername();
        if (userService.getUsername(username)) {
            return R.error(400, "用户名" + username + "已存在!");
        }
        user.setGmtCreate(new Date());
        user.setGmtModified(new Date());
        userService.saveUser(user);
        return R.ok(200, "注册成功!");
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public R login(HttpSession session, @RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        if (!userService.getUsername(username)) {
            return R.error(401, "帐号不存在!");
        }
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!md5Password.equals(userService.getPasswordByUsername(username))) {
            return R.error(402, "帐号或密码不正确!");
        } else {
            User user = userService.getUserByUsername(username);
            session.setAttribute("loginUser", user);
            return R.ok(201, "登录成功!");
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("loginUser");
        return "redirect:/";
    }

}
