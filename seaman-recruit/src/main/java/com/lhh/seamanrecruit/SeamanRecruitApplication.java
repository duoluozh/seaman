package com.lhh.seamanrecruit;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

@Slf4j
@SpringBootApplication
@EnableCaching
@MapperScan(basePackages  = "com.lhh.seamanrecruit.dao")
public class SeamanRecruitApplication extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        //      + "health: \thttp://{}:{}/swagger-ui.html"
        Environment run = SpringApplication.run(SeamanRecruitApplication.class, args).getEnvironment();
        String port = run.getProperty("server.port", "8090");
        String actPort = run.getProperty("management.server.port", "8090");
        log.info("Access URLs:\n----------------------------------------------------------\n\t"
                        + "Local: \t\thttp://127.0.0.1:{}\n\t"
                        + "External: \thttp://{}:{}\n\t"
                        + "Swagger: \thttp://{}:{}/doc.html"
                        + "\n----------------------------------------------------------",
                port,
                InetAddress.getLocalHost().getHostAddress(),
                port,
                InetAddress.getLocalHost().getHostAddress(),
                actPort
        );
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // TODO Auto-generated method stub
        return builder.sources(SeamanRecruitApplication.class);
    }


}
