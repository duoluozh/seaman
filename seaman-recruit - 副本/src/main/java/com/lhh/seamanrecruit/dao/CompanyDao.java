package com.lhh.seamanrecruit.dao;

import com.lhh.seamanrecruit.dto.position.PositionDto;
import com.lhh.seamanrecruit.entity.Company;
import com.lhh.seamanrecruit.entity.Position;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 公司Dao
 *
 * @author yslong
 * @date 2022-04-12 14:10:00
 */
@Repository
public interface CompanyDao extends BaseMapper<Company> {

    Company selectByUserId(@Param("userId") Long userId);

}
