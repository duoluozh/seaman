package com.lhh.seamanrecruit.dao;

import com.lhh.seamanrecruit.entity.UserPosition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.time.LocalDateTime;

/**
 * 用户职员表Dao
 *
 * @author zhh
 * @date 2022-04-15 22:13:47
 */
@Repository
public interface UserPositionDao extends BaseMapper<UserPosition> {

    /**
     * 根据用户id与简历id查询是否存在
     * @param userId
     * @param id
     * @return
     */
    UserPosition selectUserPosition(@Param("userId") Long userId,@Param("positionId") Long id,@Param("dateTime") LocalDateTime dateTime);
}
