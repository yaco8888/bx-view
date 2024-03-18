package com.bx.portrait.system;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
/**
 * 登录过滤器
 */
public class LoginFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
        HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // 简单地判断 session 中是否存在用户信息作为登录状态验证
        if (null == request.getSession().getAttribute("adminName")) {
            response.sendRedirect("/login"); // 未登录则重定向到登录页面
        } else {
            filterChain.doFilter(request, response); // 已登录则继续请求
        }
    }


}
