package com.lhh.seamanrecruit.service.ysltest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
/**
 * 测试服务接口
 *
 * @author yslong
 * @date 2022-05-01 17:22:55
 */
public interface YsltestService {

        /**
         * 测试新增数据
         *
         * @param entity 实例对象
         * @return 实例对象
         */
        Ysltest add(Ysltest entity);

        /**
         * 测试通过主键删除数据
         *
         * @param ids 主键
         * @return 是否成功
         */
        boolean deleteById(List<Integer> ids);

        /**
         * 测试根据id修改数据
         *
         * @param entity 实例对象
         * @return 实例对象
         */
        Ysltest updateById(Ysltest entity);

        /**
         * 测试通过ID查询单条数据
         *
         * @param id 主键
         * @return 实例对象
         */
        Ysltest queryById(Integer id);

        /**
         * 测试分页查询
         *
         * @param dto 查询条件
         * @return 查询结果
         */
        Page<Ysltest> queryByPage(YsltestDto dto);

}