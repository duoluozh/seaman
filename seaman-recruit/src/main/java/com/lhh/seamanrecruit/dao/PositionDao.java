package com.lhh.seamanrecruit.dao;

import com.lhh.seamanrecruit.dto.position.PositionCompanyDto;
import com.lhh.seamanrecruit.dto.position.PositionDto;
import com.lhh.seamanrecruit.entity.Position;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 招聘Dao
 *
 * @author yslong
 * @date 2022-04-12 14:09:33
 */
@Repository
public interface PositionDao extends BaseMapper<Position> {

    List<PositionDto> selectPageList(@Param("param") Position entity);

    PositionCompanyDto selectByPositionCompany(@Param("id") Long id);
}
