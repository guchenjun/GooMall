package com.milen.controller;

import com.milen.model.po.Ad;
import com.milen.model.po.User;
import com.milen.model.vo.R;
import com.milen.service.AdService;
import com.milen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @Autowired
    AdService adService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(HttpSession session, Model model) {
        String msg = (String) session.getAttribute("msg");
        if (msg != null) {
            model.addAttribute("msg", msg);
            session.removeAttribute("msg");
        }
        List<Ad> adList = adService.listAd();
        model.addAttribute("ad0", adList.get(0));
        return "index";
    }

    @RequestMapping(value = "/feedback", method = RequestMethod.POST)
    @ResponseBody
    public R feedback(@RequestParam("content") String content,
                      HttpSession session) {
        User user = (User)session.getAttribute("loginUser");
        if (user == null) {
            return R.error(400, "请先登录!");
        }
        userService.saveFeedback(content, user.getUsername());
        return R.ok(200, "添加反馈成功，感谢您的支持！");
    }

}
