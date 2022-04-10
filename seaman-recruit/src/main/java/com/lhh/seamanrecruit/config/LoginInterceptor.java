package com.lhh.seamanrecruit.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lhh.seamanrecruit.dao.UserDao;
import com.lhh.seamanrecruit.entity.User;
import com.lhh.seamanrecruit.service.user.UserService;
import com.lhh.seamanrecruit.utils.JwtUtils;
import com.lhh.seamanrecruit.utils.ResultUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: yslong
 * @Date: 2022/4/9 16:32
 * @Description: 请求拦截
 */
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 从请求投中获取token
        String token = request.getHeader("Access-Token");
        if (token == null) {
            throw new RuntimeException("toke-isNull");
        }
        Claims decode;
        try {
            decode = JwtUtils.decode(token);
        } catch (Exception e) {
           throw new RuntimeException("token-error");

        }
        // 根据token携带的同户名查询用户是否存在
        User user = userDao.selectOne(new QueryWrapper<User>().eq("user_name", decode.get("username")));
        if (user == null) {
            throw new RuntimeException("user-isNull");
        }
        // 验证token
        boolean verify = JwtUtils.isVerify(token);
        if (!verify) {
            throw new RuntimeException("token-error");
        }
        return true;
    }
}
