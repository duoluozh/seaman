package com.lhh.seamanrecruit.service.ysltest.impl;


import com.lhh.seamanrecruit.service.ysltest.YsltestService;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 测试服务实现类
 *
 * @author yslong
 * @date 2022-05-01 17:22:55
 */
@Slf4j
@Service
public class YsltestServiceImpl implements YsltestService {

	@Autowired
	private YsltestDao ysltestDao;

	/**
	 * 测试新增数据
	 *
	 * @param entity 实例对象
	 * @return 实例对象
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Ysltest add(Ysltest entity) {
		ysltestDao.insert(entity);
		return entity;
	}

	/**
	 * 测试通过主键删除数据
	 *
	 * @param ids 主键
	 * @return 是否成功
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean deleteById(List<Integer> ids) {
		return ysltestDao.deleteBatchIds(ids) > 0;
	}

	/**
	 * 测试修改数据
	 *
	 * @param entity 实例对象
	 * @return 实例对象
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Ysltest updateById(Ysltest entity) {
		ysltestDao.updateById(entity);
		return queryById(entity.getId());
	}

	/**
	 * 测试通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	@Override
	public Ysltest queryById(Integer id) {
		return ysltestDao.selectById(id);
	}

	/**
	 * 测试分页查询
	 *
	 * @param dto 查询条件
	 * @return 查询结果
	 */
	@Override
	public Page<Ysltest> queryByPage(YsltestDto dto) {
		QueryWrapper<Ysltest> queryWrapper =  new QueryWrapper<>();
		queryWrapper.orderByAsc("id");
		Page<Ysltest> page = new Page<>(dto.getPageNum(),dto.getPageSize());
		return (Page)ysltestDao.selectPage(page, queryWrapper);
	}

}