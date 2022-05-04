package com.lhh.seamanrecruit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: yslong
 * @Date: 2022/4/9 16:37
 * @Description:
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                //需要进行拦截的请求
                .addPathPatterns("/**")
                // 不拦截的请求
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/register")
                .excludePathPatterns("/user/forgetPassword")
                .excludePathPatterns("/user/sendVerificationCode")
                .excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/swagger-ui.html/**")
                .excludePathPatterns("/webjars/**")
                .excludePathPatterns("/doc.html")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/fonts/**")
                .excludePathPatterns("/*.html")
                .excludePathPatterns("/");

    }


}
