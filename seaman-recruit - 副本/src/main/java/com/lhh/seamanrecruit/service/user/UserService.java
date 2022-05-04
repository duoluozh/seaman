package com.lhh.seamanrecruit.service.user;

import com.lhh.seamanrecruit.dto.user.*;
import com.lhh.seamanrecruit.entity.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhh.seamanrecruit.dto.BaseQueryDto;
import com.lhh.seamanrecruit.utils.Result;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
/**
 * 用户服务接口
 *
 * @author yslong
 * @date 2022-04-08 13:40:42
 */
public interface UserService {

        /**
         * 用户注册
         *
         * @param registerDto 实例对象
         * @return 实例对象
         */
        User register(RegisterDto registerDto);


        /**
         * 用户登录
         * @param loginReqDto
         * @return
         */
        LoginResDto login(LoginReqDto loginReqDto);


        /**
         * 修改密码
         * @param reqDto
         * @return
         */
        Boolean updatePassword(UpdatePasswordReqDto reqDto);

        /**
         * 通过主键删除数据
         *
         * @param ids 主键
         * @return 是否成功
         */
        boolean deleteById(List<Long> ids);

        /**
         * 通过ID查询单条数据
         *
         * @param id 主键
         * @return 实例对象
         */
        User queryById(Long id);

        /**
         * 分页查询
         *
         * @param entity 筛选条件
         * @param pageRequest      分页对象
         * @return 查询结果
         */
        Page<User> queryByPage(UserDto dto);

        /**
         * 发送邮箱验证码
         * @param userName
         * @return
         */
        String verificationCode(String userName);

        /**
         * 忘记密码-修改密码
         * @param dto
         * @return
         */
        Result forgetPassword(LoginReqDto dto);

        /**
         * 文件上传
         * @param userId 用户id
         * @param file 头像文件
         * @return
         */
        Result pictureUpload(Long userId, MultipartFile file);
}