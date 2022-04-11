package com.lhh.seamanrecruit.service.user;

import com.lhh.seamanrecruit.dto.user.LoginReqDto;
import com.lhh.seamanrecruit.dto.user.LoginResDto;
import com.lhh.seamanrecruit.dto.user.UserDto;
import com.lhh.seamanrecruit.entity.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhh.seamanrecruit.dto.BaseQueryDto;

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
         * @param userDto 实例对象
         * @return 实例对象
         */
        User register(UserDto userDto);


        /**
         * 用户登录
         * @param loginReqDto
         * @return
         */
        LoginResDto login(LoginReqDto loginReqDto);


        /**
         * 通过主键删除数据
         *
         * @param ids 主键
         * @return 是否成功
         */
        boolean deleteById(List<Long> ids);

        /**
         * 根据id修改数据
         *
         * @param entity 实例对象
         * @return 实例对象
         */
        User updateById(User  entity);

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
        Page<User> queryByPage(User entity, BaseQueryDto pageRequest);

}