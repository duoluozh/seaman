package com.lhh.seamanrecruit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: yslong
 * @Date: 2022/3/14 15:17
 * @Description: swagger配置类
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //是否开启swagger (true 开启  false隐藏。生产环境建议隐藏)
//                .enable(false)
                .select()
                //扫描的路径包,设置basePackage会将包下的所有被@Api标记类的所有方法作为api
                .apis(RequestHandlerSelectors.basePackage("com.lhh.seamanrecruit.controller"))
                //指定路径处理PathSelectors.any()代表所有的路径
                .paths(PathSelectors.any())
                .build();
    }
    //swagger访问地址：http://localhost:8090/swagger-ui.html

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //设置文档标题(API名称)
                .title("龙晖浩的接口文档")
                //文档描述
                .description("大佬专用，萌新勿动！！！")
                //服务条款URL
//                .termsOfServiceUrl("http://localhost:8090/")
                //版本号
                .version("1.0.0")
                .build();
    }

}
