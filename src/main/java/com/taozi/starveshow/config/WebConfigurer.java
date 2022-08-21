package com.taozi.starveshow.config;

import com.taozi.starveshow.component.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
                .excludePathPatterns("/starve/login","/starve/loginHandle","/starve/getConsole","/starve/respawn","/css/**","/img/**")
                .addPathPatterns("/**");
    }
}
