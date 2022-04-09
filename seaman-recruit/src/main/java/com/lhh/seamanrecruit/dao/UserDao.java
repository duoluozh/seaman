package com.lhh.seamanrecruit.dao;

import com.lhh.seamanrecruit.dto.user.LoginReqDto;
import com.lhh.seamanrecruit.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 用户Dao
 *
 * @author yslong
 * @date 2022-04-08 13:40:42
 */
@Repository
public interface UserDao extends BaseMapper<User> {


    /**
     * 查询用户名是否存在
     * @param userName
     * @return
     */
    User selectByName(@Param("userName") String userName);

    /**
     * 查询邮箱是否被占用
     * @param email
     * @return
     */
    User selectByEmail(@Param("email") String email);

    /**
     * 用户登录（根据用户名密码查询用户）
     * @param loginReqDto
     * @return
     */
    User login(LoginReqDto loginReqDto);


}
