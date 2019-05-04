package com.milen.controller.admin;


import com.milen.pojo.po.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {
        return "admin";
    }

}
