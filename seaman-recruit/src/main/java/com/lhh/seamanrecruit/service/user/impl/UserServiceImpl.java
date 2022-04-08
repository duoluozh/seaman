package com.lhh.seamanrecruit.service.user.impl;

import com.lhh.seamanrecruit.entity.User;
import com.lhh.seamanrecruit.dao.UserDao;
import com.lhh.seamanrecruit.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhh.seamanrecruit.dto.BaseQueryDto;
import java.util.List;

/**
 * 用户服务实现类
 *
 * @author yslong
 * @date 2022-04-08 10:50:08
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	/**
	 * 新增数据
	 *
	 * @param entity 实例对象
	 * @return 实例对象
	 */
	@Override
	public User insert(User entity) {
		userDao.insert(entity);
		return entity;
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
	 * @param entity 筛选条件
	 * @param pageRequest 分页对象
	 * @return 查询结果
	 */
	@Override
	public Page<User> queryByPage(User entity, BaseQueryDto pageRequest) {
		QueryWrapper<User> queryWrapper =  new QueryWrapper<>();
		queryWrapper.orderByAsc("id");
		Page<User> page = new Page<>(pageRequest.getPageNum(),pageRequest.getPageSize());
		page = (Page)userDao.selectPage(page, queryWrapper);
		return page;
	}

}