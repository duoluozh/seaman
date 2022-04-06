package com.lhh.seamanrecruit.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @Author: yslong
 * @Date: 2022/3/15 10:10
 * @Description: 日志切面 打印请求日志
 */
@Slf4j
@Aspect
@Component
public class LogAop {
    /**
     * 进入方法时间戳
     */
    private Long startTime;

    /**
     * 自定义切点
     */
    private final String POINTCUT = "execution(* com.lhh.seamanrecruit.controller..*(..))";

    /**
     * 前置通知，方法之前执行
     *
     * @param joinPoint
     */
    @Before(POINTCUT)
    public void doBefore(JoinPoint joinPoint) {
        // 获取当前的HttpServletRequest对象
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 打印请求的内容
        startTime = System.currentTimeMillis();
        log.info("----------请求Url : {}", request.getRequestURL().toString());
        log.info("----------请求方式 : {}", request.getMethod());
        log.info("----------请求参数 : {}", Arrays.toString(joinPoint.getArgs()));
        String remoteAddr = request.getRemoteAddr();
        log.info("----------请求ip : {}", "0:0:0:0:0:0:0:1".equals(remoteAddr) ? "127.0.0.1" : remoteAddr);
    }


    /**
     * 返回通知 正常结束时进入此方法
     *
     * @param ret
     */
    @AfterReturning(returning = "ret", pointcut = POINTCUT)
    public void doAfterReturning(Object ret) {
        /** 方法结束时间戳(计时) */
        Long endTime = System.currentTimeMillis();
        log.info("----------耗时 : {}", (endTime - startTime));
        // 处理完请求，返回内容
        log.info("----------返回结果 : {}", ret);
    }

    /**
     * 异常通知： 1. 在目标方法非正常结束，发生异常或者抛出异常时执行
     *
     * @param throwable
     */
    @AfterThrowing(pointcut = POINTCUT, throwing = "throwable")
    public void doAfterThrowing(Throwable throwable) {
        // 保存异常日志记录
        log.error("----------发生异常时间 : {}", LocalDateTime.now());
        log.error("----------异常信息 : {}", throwable.getMessage());
    }
}

