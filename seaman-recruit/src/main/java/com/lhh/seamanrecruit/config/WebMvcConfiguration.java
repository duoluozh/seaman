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
                .excludePathPatterns("/user/forgetPassword")
                .excludePathPatterns("/user/sendVerificationCode")
                .excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/webjars/**")
                .excludePathPatterns("/v2/**")
                .excludePathPatterns("/swagger-ui.html/**")
                .excludePathPatterns("/doc.html")
                .excludePathPatterns("/user/register")
                .excludePathPatterns("/*")
                .excludePathPatterns("/manager/html");

    }


}
