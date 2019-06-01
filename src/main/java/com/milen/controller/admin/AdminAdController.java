package com.milen.controller.admin;


import com.milen.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminAdController {

    @Autowired
    AdService adService;

    @RequestMapping(value = "/advertisement", method = RequestMethod.GET)
    public String advertisement() {
        adService.listAd();
        return "admin";
    }
}
