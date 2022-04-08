package com.lhh.seamanrecruit.service.user.impl;

import com.lhh.seamanrecruit.dto.user.UserDto;
import com.lhh.seamanrecruit.entity.User;
import com.lhh.seamanrecruit.dao.UserDao;
import com.lhh.seamanrecruit.service.user.UserService;
import com.lhh.seamanrecruit.utils.Result;
import com.lhh.seamanrecruit.utils.ResultUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhh.seamanrecruit.dto.BaseQueryDto;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 用户服务实现类
 *
 * @author yslong
 * @date 2022-04-08 13:40:42
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 新增数据
     *
     * @param userDto 实例对象
     * @return 实例对象
     */
    @Override
    public Result register(UserDto userDto) {
        String userName = userDto.getUserName();
        String password = userDto.getPassword();
        String email = userDto.getEmail();
        Integer userType = userDto.getUserType();

        if (StringUtils.isBlank(userName)) {
            return ResultUtils.error("用户名不能为空！");
        }
        if (StringUtils.isBlank(password)) {
            return ResultUtils.error("密码不能为空！");
        }
        if (StringUtils.isBlank(email)) {
            return ResultUtils.error("邮箱不能为空！");
        }
        if (userType == null) {
            return ResultUtils.error("用户类型不能为空！");
        }
        User user = new User();
        userDao.insert(user);
        return ResultUtils.success();
    }

    /**
     * 通过主键删除数据
     *
     * @param ids 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(List<Long> ids) {
        return userDao.deleteBatchIds(ids) > 0;
    }

    /**
     * 修改数据
     *
     * @param entity 实例对象
     * @return 实例对象
     */
    @Override
    public User updateById(User entity) {
        userDao.updateById(entity);
        return queryById(entity.getId());
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Long id) {
        return userDao.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param entity      筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<User> queryByPage(User entity, BaseQueryDto pageRequest) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("id");
        Page<User> page = new Page<>(pageRequest.getPageNum(), pageRequest.getPageSize());
        page = (Page) userDao.selectPage(page, queryWrapper);
        return page;
    }

}