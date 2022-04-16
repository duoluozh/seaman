package com.lhh.seamanrecruit.utils;

import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: yslong
 * @Date: 2022/4/11 14:56
 * @Description: 用户工具类
 */
public class UserUtils {

    /**
     * 获取当前登录人
     * @return 当前登录人
     */
    public static String getLoginUserName(){
        // 获取request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // 从request中取出token
        String token = request.getHeader("Access-Token");
        if (StringUtils.isBlank(token)) {
            throw new RuntimeException("token-isNull");
        }
        Claims decode ;
        try {
            decode = JwtUtils.decode(token);
        } catch (Exception e) {
            throw new RuntimeException("error-token");
        }
        // 将存在token中的用户名取出
        return (String)decode.get("userName");
    }

    /**
     * 获取当前登录人id
     * @return 当前登录人
     */
    public static Long getLoginUserId(){
        // 获取request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // 从request中取出token
        String token = request.getHeader("Access-Token");
        if (StringUtils.isBlank(token)) {
            throw new RuntimeException("token-isNull");
        }
        Claims decode ;
        try {
            decode = JwtUtils.decode(token);
        } catch (Exception e) {
            throw new RuntimeException("error-token");
        }
        // 将存在token中的用户Id取出
        return Long.valueOf(String.valueOf(decode.get("userId")));
    }

}
