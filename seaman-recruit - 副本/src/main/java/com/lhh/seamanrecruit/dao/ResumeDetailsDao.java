package com.lhh.seamanrecruit.dao;

import com.lhh.seamanrecruit.dto.resume.ResumeAddDto;
import com.lhh.seamanrecruit.entity.ResumeDetails;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 简历明细Dao
 *
 * @author yslong
 * @date 2022-04-12 14:10:45
 */
@Repository
public interface ResumeDetailsDao extends BaseMapper<ResumeDetails> {

    List<ResumeDetails> selectByMasterId(@Param("id") Long id);
}
