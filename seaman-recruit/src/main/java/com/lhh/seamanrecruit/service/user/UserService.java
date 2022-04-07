
package com.lhh.seamanrecruit.service.user;

import com.lhh.seamanrecruit.entity.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;
/**
 * 用户表服务接口
 *
 * @author yslong
 * @date 2022-04-07 20:50:10
 */
public interface UserService {

        /**
         * 通过ID查询单条数据
         *
         * @param id 主键
         * @return 实例对象
         */
        User queryById(Long id);

        /**
         * 分页查询
         *
         * @param entity 筛选条件
         * @param pageRequest      分页对象
         * @return 查询结果
         */
        Page<User> queryByPage(User entity, PageRequest pageRequest);

        /**
         * 新增数据
         *
         * @param entity 实例对象
         * @return 实例对象
         */
        User insert(User entity);

        /**
         * 根据id修改数据
         *
         * @param entity 实例对象
         * @return 实例对象
         */
        User updateById(User  entity);

        /**
         * 通过主键删除数据
         *
         * @param ids 主键
         * @return 是否成功
         */
        boolean deleteById(List<Long> ids);
}