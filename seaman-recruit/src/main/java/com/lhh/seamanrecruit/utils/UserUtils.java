package com.lhh.seamanrecruit.utils;

import com.lhh.seamanrecruit.constant.Constant;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @Author: yslong
 * @Date: 2022/4/11 14:56
 * @Description: 用户工具类
 */
public class UserUtils {

    /**
     * 获取当前登录人
     *
     * @return 当前登录人
     */
    public static String getLoginUserName() {
        String token = getLoginToken();
        Claims decode;
        try {
            decode = JwtUtils.decode(token);
        } catch (Exception e) {
            throw new RuntimeException(Constant.ERROR_TOKEN);
        }
        // 将存在token中的用户名取出
        return (String) decode.get("userName");
    }

    /**
     * 获取当前登录人id
     *
     * @return 当前登录人
     */
    public static Long getLoginUserId() {
        String token = getLoginToken();
        Claims decode;
        try {
            decode = JwtUtils.decode(token);
        } catch (Exception e) {
            throw new RuntimeException(Constant.ERROR_TOKEN);
        }
        // 将存在token中的用户Id取出
        return Long.valueOf(String.valueOf(decode.get("userId")));
    }


    /**
     * 获取当前登录token
     * @return token
     */
    private static String getLoginToken() {
        // 获取request
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        // 从request中取出token
        String token = null;
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            throw new RuntimeException(Constant.TOKEN_ISNULL);
        }
        for (Cookie cookie : cookies) {
            if (Constant.TOKEN.equals(cookie.getName())) {
                token = cookie.getValue();
            }
        }
        if (StringUtils.isBlank(token)) {
            throw new RuntimeException(Constant.TOKEN_ISNULL);
        }
        return token;
    }

}
