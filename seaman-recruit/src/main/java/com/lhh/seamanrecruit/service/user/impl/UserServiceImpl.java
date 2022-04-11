package com.lhh.seamanrecruit.service.user.impl;

import com.lhh.seamanrecruit.constant.Constant;
import com.lhh.seamanrecruit.dto.user.LoginReqDto;
import com.lhh.seamanrecruit.dto.user.LoginResDto;
import com.lhh.seamanrecruit.dto.user.UpdatePasswordReqDto;
import com.lhh.seamanrecruit.dto.user.UserDto;
import com.lhh.seamanrecruit.entity.User;
import com.lhh.seamanrecruit.dao.UserDao;
import com.lhh.seamanrecruit.service.user.UserService;
import com.lhh.seamanrecruit.utils.*;
import com.qiniu.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhh.seamanrecruit.dto.BaseQueryDto;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotBlank;
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
    public User register(UserDto userDto) {
        String userName = userDto.getUserName();
        String password = userDto.getPassword();
        String email = userDto.getEmail();
        if (userDao.selectByName(userName) != null) {
            throw new RuntimeException(Constant.USERNAME_OCCUPY);
        }

        if (userDao.selectByEmail(email) != null) {
            throw new RuntimeException(Constant.EMAIL_OCCUPY);
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        // 将用户密码进行加密后存储
        user.setPassword(Md5Util.generate(password));
        user.setCreatedTime(LocalDateTime.now());
        user.setUpdatedTime(LocalDateTime.now());
        userDao.insert(user);
        user.setPassword(null);
        return user;
    }


    @Override
    public LoginResDto login(LoginReqDto loginReqDto) {
        String userName = loginReqDto.getUserName();
        // 用户输入的密码
        String loginPassword = loginReqDto.getPassword();
        User user = userDao.selectByName(userName);
        if (user == null) {
            throw new RuntimeException(Constant.USERNAME_NOT_EXIST);
        }
        // 校验用户输入的密码和注册的密码是否正确
        if (!Md5Util.verify(loginPassword, user.getPassword())) {
            throw new RuntimeException(Constant.PASSWORD_ERROR);
        }
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", userName);
        String token = JwtUtils.getToken(userName, TOKEN_EXPIRE_TIME, claims);
        // 将token存入redis中
        redisUtils.set(userName, token, TOKEN_EXPIRE_TIME);
        LoginResDto res = new LoginResDto();
        res.setCreatedTime(user.getCreatedTime());
        res.setUpdatedTime(user.getUpdatedTime());
        res.setUserName(user.getUserName());
        res.setUserType(user.getUserType());
        res.setToken(token);
        return res;
    }

    /**
     * 修改密码
     *
     * @param reqDto
     * @return
     */
    @Override
    @Transactional
    public Boolean updatePassword(UpdatePasswordReqDto reqDto) {
        String userName = reqDto.getUserName();
        String oldPassword = reqDto.getOldPassword();
        String newPassword = reqDto.getNewPassword();
        User user = userDao.selectByName(userName);
        if (user == null) {
            throw new RuntimeException(Constant.USERNAME_NOT_EXIST);
        }
        // 校验用户输入的密码和注册的密码是否正确
        if (!Md5Util.verify(oldPassword, user.getPassword())) {
            throw new RuntimeException(Constant.PASSWORD_ERROR);
        }
        //密码加密
        user.setPassword(Md5Util.generate(newPassword));
        userDao.updateById(user);
        return true;
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

//    /**
//     * 修改密码
//     *
//     * @param entity
//     * @return 实例对象
//     */
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public User updateById(User entity) {
//        userDao.updateById(entity);
//        entity.setUpdatedTime(LocalDateTime.now());
//        return queryById(entity.getId());
//    }

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