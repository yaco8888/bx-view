package com.bx.portrait;

import com.bx.portrait.system.LoginFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName BXApplication
 * @Description 启动项
 * @Author @bx
 * @Version 1.0
 */
@SpringBootApplication
public class BXApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BXApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BXApplication.class);
    }

    /**
     * 装配自定义的过滤器
     */
    @Bean
    public FilterRegistrationBean<LoginFilter> loginFilter() {
        FilterRegistrationBean<LoginFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new LoginFilter());
        registrationBean.addUrlPatterns("/admin/*"); // 设置过滤路径，比如只拦截以 /admin/ 开头的路径
        return registrationBean;
    }
}
