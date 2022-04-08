package com.lhh.seamanrecruit.dao;

import com.lhh.seamanrecruit.entity.User;
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
    User selectByName(String userName);


}
