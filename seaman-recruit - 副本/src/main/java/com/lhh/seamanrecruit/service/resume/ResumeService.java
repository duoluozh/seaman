package com.lhh.seamanrecruit.service.resume;

import com.github.pagehelper.PageInfo;
import com.lhh.seamanrecruit.dto.resume.ResumeAddDto;
import com.lhh.seamanrecruit.dto.resume.ResumeDto;
import com.lhh.seamanrecruit.entity.Resume;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhh.seamanrecruit.dto.BaseQueryDto;
import java.util.List;
/**
 * 简历服务接口
 *
 * @author yslong
 * @date 2022-04-12 14:10:30
 */
public interface ResumeService {

        /**
         * 新增数据
         *
         * @param entity 实例对象
         * @return 实例对象
         */
        ResumeAddDto insert(ResumeAddDto entity);

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
        ResumeAddDto updateById(ResumeAddDto  entity);

        /**
         * 通过ID查询单条数据
         *
         * @param id 主键
         * @return 实例对象
         */
        ResumeAddDto queryById(Long id);

        /**
         * 分页查询
         *
         * @param resumeDto 筛选条件
         * @return 查询结果
         */
        PageInfo<ResumeDto> queryByPage(ResumeDto resumeDto);

        /**
         * 分页查询
         *
         * @param resume 筛选条件
         * @return 查询结果
         */
        PageInfo<ResumeDto> queryResumePage(ResumeDto resume);

        /**
         * 查询当前用户简历
         * @param loginUserId 当前登录用户id
         * @return
         */
        ResumeAddDto queryByUserId(Long loginUserId);
}