package com.bx.portrait;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

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
}
