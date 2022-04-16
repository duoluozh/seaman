package com.lhh.seamanrecruit.service.company.impl;

import com.lhh.seamanrecruit.entity.Company;
import com.lhh.seamanrecruit.dao.CompanyDao;
import com.lhh.seamanrecruit.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhh.seamanrecruit.dto.BaseQueryDto;
import java.util.List;

/**
 * 公司服务实现类
 *
 * @author yslong
 * @date 2022-04-12 14:10:00
 */
@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDao companyDao;

	/**
	 * 新增数据
	 *
	 * @param entity 实例对象
	 * @return 实例对象
	 */
	@Override
	@Transactional
	public Company insert(Company entity) {
		companyDao.insert(entity);
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
		return companyDao.deleteBatchIds(ids) > 0;
	}

	/**
	 * 修改数据
	 *
	 * @param entity 实例对象
	 * @return 实例对象
	 */
	@Override
	@Transactional
	public Company updateById(Company entity) {
		companyDao.updateById(entity);
		return queryById(entity.getId());
	}

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	@Override
	public Company queryById(Long id) {
		return companyDao.selectById(id);
	}

	/**
	 * 分页查询
	 *
	 * @param entity 筛选条件
	 * @param pageRequest 分页对象
	 * @return 查询结果
	 */
	@Override
	public Page<Company> queryByPage(Company entity, BaseQueryDto pageRequest) {
		QueryWrapper<Company> queryWrapper =  new QueryWrapper<>();
		queryWrapper.orderByAsc("id");
		Page<Company> page = new Page<>(pageRequest.getPageNum(),pageRequest.getPageSize());
		page = (Page)companyDao.selectPage(page, queryWrapper);
		return page;
	}

}