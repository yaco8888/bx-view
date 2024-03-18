package com.bx.portrait.admin.controller;

import com.bx.portrait.admin.service.AdminService;
import com.bx.portrait.room.entity.ClassRoom;
import com.bx.portrait.utils.result.ResultMsg;
import com.bx.portrait.utils.result.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    @RequestMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("system/index");
    }


    @GetMapping("/course")
    public ModelAndView course() {
        return new ModelAndView("system/course/index");
    }

    /**
     * 查询所有的课程
     */
    @RequestMapping("/list")
    public ResultMsg list() {
        return ResultUtils.SUCCESS(new ClassRoom().selectAll());
    }


}
