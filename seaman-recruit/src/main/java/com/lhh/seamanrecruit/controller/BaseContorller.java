package com.lhh.seamanrecruit.controller;

import com.lhh.seamanrecruit.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import javax.servlet.http.HttpServletRequest;

/**
 * @author zhh
 * @date 2022/4/15 16:50
 * @description 通用方法
 */
public class BaseContorller {

    /**
     * 获取token用户id
     * @param request
     * @return userId
     */
    public Long getUserId(HttpServletRequest request) {

        String token = request.getHeader("Access-Token");
        if (StringUtils.isBlank(token)) {
            return null;
        }
        Claims decode = JwtUtils.decode(token);
        Long userId = Long.valueOf(String.valueOf(decode.get("userId")));
        return userId;
    }
}
