package com.lhh.seamanrecruit.dao;

import com.lhh.seamanrecruit.entity.Resume;
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
    List<Resume> selectPageList(Resume entity);
}
