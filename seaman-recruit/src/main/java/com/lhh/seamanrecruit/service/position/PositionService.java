package com.lhh.seamanrecruit.service.position;

import com.lhh.seamanrecruit.entity.Position;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhh.seamanrecruit.dto.BaseQueryDto;
import java.util.List;
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
         * @return 实例对象
         */
        Position insert(Position entity);

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
        Position queryById(Long id);

        /**
         * 分页查询
         *
         * @param entity 筛选条件
         * @param pageRequest      分页对象
         * @return 查询结果
         */
        Page<Position> queryByPage(Position entity, BaseQueryDto pageRequest);

}