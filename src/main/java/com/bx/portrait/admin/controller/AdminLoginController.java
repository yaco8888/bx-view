package com.bx.portrait.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.bx.portrait.admin.entity.Admin;
import com.bx.portrait.room.entity.ClassRoom;
import com.bx.portrait.system.SessionUtils;
import com.bx.portrait.utils.MD5Utils;
import com.bx.portrait.utils.result.ResultMsg;
import com.bx.portrait.utils.result.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.MessageDigest;

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

    /**
     * 用户客户端
     * @return
     */
    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("client/index");
    }

    /**
     * 登录
     */
    @PostMapping("/save")
    public ResultMsg save(Admin admin) {
        Admin admin1 = new Admin().selectOne(new LambdaQueryWrapper<>(Admin.class).eq(Admin::getAdminUser, admin.getAdminUser()));
        if (null == admin1) {
            return ResultUtils.ERROR("用户不存在");
        }
        if (!admin1.getAdminPassword().equals(MD5Utils.toMd5(admin.getAdminPassword()))) {
            return ResultUtils.ERROR("密码错误");
        }
        SessionUtils.setAdminUser(admin.getAdminUser());
        return ResultUtils.SUCCESS();
    }

    /**
     * 查询所有的课程
     */
    @RequestMapping("/list")
    public ResultMsg list() {
        return ResultUtils.SUCCESS(new ClassRoom().selectAll());
    }

    /**
     * 退出
     */
    @GetMapping("/out")
    public ModelAndView out() {
        SessionUtils.removeSession();
        return new ModelAndView("system/login");
    }

}
