package com.lhh.seamanrecruit.service.user.impl;

import com.lhh.seamanrecruit.dto.user.LoginReqDto;
import com.lhh.seamanrecruit.dto.user.LoginResDto;
import com.lhh.seamanrecruit.dto.user.UserDto;
import com.lhh.seamanrecruit.entity.User;
import com.lhh.seamanrecruit.dao.UserDao;
import com.lhh.seamanrecruit.service.user.UserService;
import com.lhh.seamanrecruit.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhh.seamanrecruit.dto.BaseQueryDto;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.lhh.seamanrecruit.constant.Constant.TOKEN_EXPIRE_TIME;

/**
 * 用户服务实现类
 *
 * @author yslong
 * @date 2022-04-08 13:40:42
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisUtils redisUtils;

    /**
     * 用户注册
     *
     * @param userDto 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result register(UserDto userDto) {
        String userName = userDto.getUserName();
        String password = userDto.getPassword();
        String email = userDto.getEmail();
        Integer userType = userDto.getUserType();
        if (StringUtils.isBlank(userName)) {
            return Result.error("用户名不能为空！");
        }
        if (StringUtils.isBlank(password)) {
            return Result.error("密码不能为空！");
        }
        if (StringUtils.isBlank(email)) {
            return Result.error("邮箱不能为空！");
        }
        if (userType == null) {
            return Result.error("用户类型不能为空！");
        }
        if (userDao.selectByName(userName)!=null){
            return Result.error("用户名已被占用！");
        }

        if (userDao.selectByEmail(email)!=null){
            return Result.error("该邮箱已经绑定其他用户！");
        }
        // todo 后期需要将密码进行加密
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        // 将用户密码进行加密后存储
        user.setPassword(Md5Util.generate(password));
        user.setCreatedTime(LocalDateTime.now());
        user.setUpdatedTime(LocalDateTime.now());
        userDao.insert(user);
        user.setPassword(null);
        return Result.success(user);
    }


    @Override
    public LoginResDto login(LoginReqDto loginReqDto) {
        String userName = loginReqDto.getUserName();
        // 用户输入的密码
        String loginPassword = loginReqDto.getPassword();
        if (StringUtils.isBlank(userName)) {
            throw new RuntimeException("请先输入用户名！");
        }
        if (StringUtils.isBlank(loginPassword)) {
            throw new RuntimeException("密码不能为空！");
        }
        User user = userDao.selectByName(userName);
        if (user==null){
            throw new RuntimeException("用户名不存在！");
        }
        // 校验用户输入的密码和注册的密码是否正确
        if (!Md5Util.verify(loginPassword,user.getPassword())){
            throw new RuntimeException("密码错误！");
        }
        Map<String,Object> claims = new HashMap<>();
        claims.put("username",userName);
        String token = JwtUtils.getToken(userName,TOKEN_EXPIRE_TIME, claims);
        // 将token存入cookie和redis中
//        Cookie tokenCookie = new Cookie("token", token);
        redisUtils.set(userName, token,TOKEN_EXPIRE_TIME);
        LoginResDto res = new LoginResDto();
        res.setCreatedTime(user.getCreatedTime());
        res.setUpdatedTime(user.getUpdatedTime());
        res.setUserName(user.getUserName());
        res.setUserType(user.getUserType());
        res.setToken(token);
        return res;
    }


    /**
     * 通过主键删除数据
     *
     * @param ids 主键
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(List<Long> ids) {
        return userDao.deleteBatchIds(ids) > 0;
    }

    /**
     * 修改数据
     *
     * @param entity 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public User updateById(User entity) {
        userDao.updateById(entity);
        entity.setUpdatedTime(LocalDateTime.now());
        return queryById(entity.getId());
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Long id) {
        return userDao.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param entity      筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<User> queryByPage(User entity, BaseQueryDto pageRequest) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("id");
        Page<User> page = new Page<>(pageRequest.getPageNum(), pageRequest.getPageSize());
        page = (Page) userDao.selectPage(page, queryWrapper);
        return page;
    }

}