package com.lhh.seamanrecruit.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lhh.seamanrecruit.constant.Constant;
import com.lhh.seamanrecruit.dao.UserDao;
import com.lhh.seamanrecruit.entity.User;
import com.lhh.seamanrecruit.utils.JwtUtils;
import com.lhh.seamanrecruit.utils.RedisUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: yslong
 * @Date: 2022/4/9 16:32
 * @Description: 请求拦截
 */
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 从请求投中获取token
        String token = null;
        Cookie[] cookies = request.getCookies();
        if (cookies==null) {
            throw new RuntimeException("token-isNull");
        }
        for (Cookie cookie : cookies) {
            if (Constant.TOKEN.equals(cookie.getName())) {
                token = cookie.getValue();
            }
        }
        if (StringUtils.isBlank(token)) {
            throw new RuntimeException("token-isNull");
        }
        Claims decode;
        try {
            decode = JwtUtils.decode(token);
        } catch (Exception e) {
            throw new RuntimeException("error-token");
        }
        // 根据token携带的同户名查询用户是否存在
        String username = (String) decode.get("userName");
        User user = userDao.selectOne(new QueryWrapper<User>().eq("user_name", username));
        if (user == null) {
            throw new RuntimeException("user-isNull");
        }
        //校验是否伪造token或无效token
        String userToken = (String) redisUtils.get(username);
        if (!token.equals(userToken)) {
            throw new RuntimeException("error-token");
        }
        // 重置缓存失效时间
        // 验证token是否合法
        boolean verify = JwtUtils.isVerify(token);
        if (!verify) {
            throw new RuntimeException("error-token");
        }
        return true;
    }
}
