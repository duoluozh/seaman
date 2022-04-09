package com.lhh.seamanrecruit.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lhh.seamanrecruit.dao.UserDao;
import com.lhh.seamanrecruit.entity.User;
import com.lhh.seamanrecruit.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: yslong
 * @Date: 2022/4/9 16:32
 * @Description: 请求拦截
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDao userDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 从请求投中获取token
        String token = request.getHeader("Authorization");
        if (token == null) {
            throw new RuntimeException("未携带token");
        }
        Claims decode = jwtUtils.decode(token);
        // 根据token携带的同户名查询用户是否存在
        User user = userDao.selectOne(new QueryWrapper<User>().eq("user_name", decode.get("username")));
        if (user == null) {
            throw new RuntimeException("用户不存在，请重新登录");
        }
        // 验证token
        boolean verify = jwtUtils.isVerify(token);
        if (verify) {
            return true;
        }
        return false;
    }
}
