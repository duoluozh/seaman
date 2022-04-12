package com.lhh.seamanrecruit.service.position.impl;

import com.lhh.seamanrecruit.entity.Position;
import com.lhh.seamanrecruit.dao.PositionDao;
import com.lhh.seamanrecruit.service.position.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhh.seamanrecruit.dto.BaseQueryDto;
import java.util.List;

/**
 * 招聘服务实现类
 *
 * @author yslong
 * @date 2022-04-12 14:09:33
 */
@Slf4j
@Service
public class PositionServiceImpl implements PositionService {

	@Autowired
	private PositionDao positionDao;

	/**
	 * 新增数据
	 *
	 * @param entity 实例对象
	 * @return 实例对象
	 */
	@Override
	@Transactional
	public Position insert(Position entity) {
		positionDao.insert(entity);
		return entity;
	}

	/**
	 * 通过主键删除数据
	 *
	 * @param ids 主键
	 * @return 是否成功
	 */
	@Override
	@Transactional
	public boolean deleteById(List<Long> ids) {
		return positionDao.deleteBatchIds(ids) > 0;
	}

	/**
	 * 修改数据
	 *
	 * @param entity 实例对象
	 * @return 实例对象
	 */
	@Override
	@Transactional
	public Position updateById(Position entity) {
		positionDao.updateById(entity);
		return queryById(entity.getId());
	}

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	@Override
	public Position queryById(Long id) {
		return positionDao.selectById(id);
	}

	/**
	 * 分页查询
	 *
	 * @param entity 筛选条件
	 * @param pageRequest 分页对象
	 * @return 查询结果
	 */
	@Override
	public Page<Position> queryByPage(Position entity, BaseQueryDto pageRequest) {
		QueryWrapper<Position> queryWrapper =  new QueryWrapper<>();
		queryWrapper.orderByAsc("id");
		Page<Position> page = new Page<>(pageRequest.getPageNum(),pageRequest.getPageSize());
		page = (Page)positionDao.selectPage(page, queryWrapper);
		return page;
	}

}