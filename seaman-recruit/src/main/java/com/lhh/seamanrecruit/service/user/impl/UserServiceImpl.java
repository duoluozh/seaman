package com.lhh.seamanrecruit.service.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhh.seamanrecruit.constant.Constant;
import com.lhh.seamanrecruit.dao.UserDao;
import com.lhh.seamanrecruit.dto.BaseQueryDto;
import com.lhh.seamanrecruit.dto.eamil.Email;
import com.lhh.seamanrecruit.dto.user.*;
import com.lhh.seamanrecruit.entity.User;
import com.lhh.seamanrecruit.service.company.CompanyService;
import com.lhh.seamanrecruit.service.user.UserService;
import com.lhh.seamanrecruit.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.UnsupportedEncodingException;
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

    @Autowired
    private CompanyService companyService;

    @Autowired
    private QiNiuUtil qiNiuUtil;

    /**
     * 用户注册
     *
     * @param registerDto 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public User register(RegisterDto registerDto) {
        Integer userType = registerDto.getUserType();
        String userName = registerDto.getUserName();
        String password = registerDto.getPassword();
        String email = registerDto.getEmail();
        if (userDao.selectByName(userName) != null) {
            throw new RuntimeException(Constant.USERNAME_OCCUPY);
        }
        if (userDao.selectByEmail(email) != null) {
            throw new RuntimeException(Constant.EMAIL_OCCUPY);
        }
        User user = new User();
        BeanUtils.copyProperties(registerDto, user);
        // 将用户密码进行加密后存储
        user.setPassword(Md5Util.generate(password));
        user.setCreatedTime(LocalDateTime.now());
        user.setUpdatedTime(LocalDateTime.now());
        userDao.insert(user);
        if (userType == 1) {

        }
        user.setPassword(null);
        return user;

    }


    /**
     * 用户登录
     *
     * @param loginReqDto
     * @return
     */
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
        claims.put("userName", userName);
        claims.put("userId", user.getId());
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
        user.setUpdatedTime(LocalDateTime.now());
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
        Integer userType = entity.getUserType();
        String userName = entity.getUserName();
        String email = entity.getEmail();
        if (userType != null) {
            Map<String, Object> params = new HashMap<>();
            params.put("user_type", userType);
            queryWrapper.allEq(params);
        }
        if (StringUtils.isBlank(userName)) {
            queryWrapper.like("user_name",userName);
        }
        if (StringUtils.isBlank(email)) {
            queryWrapper.like("email",email);
        }
        queryWrapper.orderByAsc("id");
        Page<User> page = new Page<>(pageRequest.getPageNum(), pageRequest.getPageSize());
        page = (Page) userDao.selectPage(page, queryWrapper);
        return page;
    }

    /**
     * 根据用户名获取邮箱并发送邮件验证码
     *
     * @param userName 用户名
     * @return
     */
    @Override
    public String verificationCode(String userName) {
        User user = userDao.selectByName(userName);
        String status = null;
        if (null != user) {
            //对邮箱发送验证码
            Email email = new Email();
            email.setSubject(Constant.EMAIL_CODE);
            String randomCode = RandomCodeUtils.getRandomCode(6);
            email.setContent(Constant.EMAIL_IS_CODE + randomCode);
            status = SendMail.sendMails(email, user.getEmail());
            redisUtils.set(Constant.EMAIL_CODE_KEY + userName, randomCode, Constant.VERIFICATION_CODE_TIME);
        }
        return status;
    }

    @Override
    public Result forgetPassword(LoginReqDto dto) {

        //获取验证码
        String randomCode = (String) redisUtils.get(Constant.EMAIL_CODE_KEY + dto.getUserName());
        if (StringUtils.isBlank(randomCode)) {
            throw new RuntimeException(Constant.VERIFICATION_CODE_ERROR);
        }
        if (!dto.getVerificationCode().equals(randomCode)) {
            throw new RuntimeException(Constant.VERIFICATION_CODE_ERROR);
        }
        //验证码正确--修改密码
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setPassword(Md5Util.generate(dto.getPassword()));

        userDao.updatePasswordByUserName(user);
        return Result.success();
    }

    /**
     * 文件上传
     *
     * @param userId 用户id
     * @param file   头像文件
     * @return 头像文件的url
     */
    @Override
    public Result pictureUpload(Long userId, MultipartFile file) {
        String fileUrl = null;
        boolean flag = qiNiuUtil.uploadMultipartFile(file, file.getOriginalFilename(), true);
        if (flag) {
            try {
                //如果上传成功则更新头像数据
                fileUrl = qiNiuUtil.fileUrl(file.getOriginalFilename());
                User user = new User();
                user.setId(userId);
                user.setHeadPortrait(fileUrl);
                userDao.updateById(user);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            //上传失败
            return Result.error();
        }
        return Result.success(fileUrl);
    }

}