package com.lhh.seamanrecruit.service.position;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import com.lhh.seamanrecruit.dto.position.PositionCompanyDto;
import com.lhh.seamanrecruit.dto.position.PositionDto;
import com.lhh.seamanrecruit.dto.position.PositionInterviewDto;
import com.lhh.seamanrecruit.entity.Position;
import com.lhh.seamanrecruit.dto.BaseQueryDto;
import com.lhh.seamanrecruit.utils.Result;

import java.util.List;
import java.util.Map;

/**
 * 招聘服务接口
 *
 * @author yslong
 * @date 2022-04-12 14:09:33
 */
public interface PositionService {

        /**
         * 新增数据
         *
         * @param entity 实例对象
         * @param userId 用户id
         * @return 实例对象
         */
        PositionDto insert(PositionDto entity, Long userId);

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
        Position updateById(Position  entity);

        /**
         * 通过ID查询单条数据
         *
         * @param id 主键
         * @return 实例对象
         */
        PositionCompanyDto queryById(Long id);

        /**
         * 分页查询
         *
         * @param positionDto 筛选条件
         * @return 查询结果
         */
        Page<Position> queryByPage(PositionDto positionDto, Long userId);

        /**
         * 简历投递
         *
         * @param id 职位id
         * @param userId   用户id
         * @return 投递结果
         */
        Map<String,String> insertDelivery(Long id, Long userId);

        /**
         * 发送面试邀请
         *
         * @param positionInterviewDto 面试邀请接口入参实体类
         * @return 结果返回
         */
        String interview(PositionInterviewDto positionInterviewDto);

        /**
         * 职位拒绝接口
         *
         * @param positionId 职位id
         * @param userId 用户id
         * @return 查询结果
         */
        String updateDelivery(Long positionId, Long userId);
}