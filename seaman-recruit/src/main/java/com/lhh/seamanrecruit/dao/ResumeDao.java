package com.lhh.seamanrecruit.dao;

import com.lhh.seamanrecruit.dto.resume.ResumeDto;
import com.lhh.seamanrecruit.entity.Resume;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * 简历Dao
 *
 * @author yslong
 * @date 2022-04-12 14:10:30
 */
@Repository
public interface ResumeDao extends BaseMapper<Resume> {

    /**
     * 查询简历列表
     * @param entity
     * @return
     */
    List<ResumeDto> selectPageList(@Param("param") ResumeDto entity);

    /**
     * 查询简历列表
     * @param resume
     * @return
     */
    List<ResumeDto> queryResumePage(@Param("param")ResumeDto resume);

    /**
     * 查询登录用户对应的简历信息
     * @param loginUserId
     * @return
     */
    Resume selectByUserId(Long loginUserId);
}
