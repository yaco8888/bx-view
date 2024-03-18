package com.bx.portrait.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class AdminLoginController {

    /**
     * 跳转登录页面
     */
    @RequestMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("system/login");
    }
}
