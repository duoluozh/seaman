package com.lhh.seamanrecruit.service.resume;

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
        Resume insert(Resume entity);

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
        Resume updateById(Resume  entity);

        /**
         * 通过ID查询单条数据
         *
         * @param id 主键
         * @return 实例对象
         */
        Resume queryById(Long id);

        /**
         * 分页查询
         *
         * @param entity 筛选条件
         * @param pageRequest      分页对象
         * @return 查询结果
         */
        Page<Resume> queryByPage(Resume entity, BaseQueryDto pageRequest);

}