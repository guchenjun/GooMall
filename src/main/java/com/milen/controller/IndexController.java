package com.milen.controller;

import com.milen.constant.UserConstant;
import com.milen.entity.User;
import com.milen.service.UserService;
import com.milen.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.milen.constant.UserConstant.REGISTER_SUCCESS;
import static com.milen.constant.UserConstant.REGISTER_SUCCESS_MSG;


@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
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


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody R login(HttpSession session, @RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        Map<String, Object> map = new HashMap<>();
        if (!userService.getUsername(username)) {
            return R.error(401, "帐号不存在!");
        }
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!md5Password.equals(userService.getPasswordByUsername(username))) {
            return R.error(402, "帐号或密码不正确!");
        } else {
            session.setAttribute("username", username);
            return R.ok(201, "登录成功!");
        }
    }

    @RequestMapping(value = "/openshop", method = RequestMethod.GET)
    public String openShop() {
        return "openshop";
    }
}
