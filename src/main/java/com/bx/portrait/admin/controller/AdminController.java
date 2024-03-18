package com.bx.portrait.admin.controller;

import com.bx.portrait.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 管理员控制层
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 跳转到管理页面
     */
    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("system/index");
    }



}
