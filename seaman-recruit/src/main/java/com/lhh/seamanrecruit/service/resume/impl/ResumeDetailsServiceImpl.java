package com.lhh.seamanrecruit.service.resume.impl;

import com.lhh.seamanrecruit.entity.ResumeDetails;
import com.lhh.seamanrecruit.dao.ResumeDetailsDao;
import com.lhh.seamanrecruit.service.resume.ResumeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhh.seamanrecruit.dto.BaseQueryDto;
import java.util.List;

/**
 * 简历明细服务实现类
 *
 * @author yslong
 * @date 2022-04-12 14:10:45
 */
@Slf4j
@Service
public class ResumeDetailsServiceImpl implements ResumeDetailsService {

	@Autowired
	private ResumeDetailsDao resumeDetailsDao;

	/**
	 * 新增数据
	 *
	 * @param entity 实例对象
	 * @return 实例对象
	 */
	@Override
	@Transactional
	public ResumeDetails insert(ResumeDetails entity) {
		resumeDetailsDao.insert(entity);
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
		return resumeDetailsDao.deleteBatchIds(ids) > 0;
	}

	/**
	 * 修改数据
	 *
	 * @param entity 实例对象
	 * @return 实例对象
	 */
	@Override
	@Transactional
	public ResumeDetails updateById(ResumeDetails entity) {
		resumeDetailsDao.updateById(entity);
		return queryById(entity.getId());
	}

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	@Override
	public ResumeDetails queryById(Long id) {
		return resumeDetailsDao.selectById(id);
	}

	/**
	 * 分页查询
	 *
	 * @param entity 筛选条件
	 * @param pageRequest 分页对象
	 * @return 查询结果
	 */
	@Override
	public Page<ResumeDetails> queryByPage(ResumeDetails entity, BaseQueryDto pageRequest) {
		QueryWrapper<ResumeDetails> queryWrapper =  new QueryWrapper<>();
		queryWrapper.orderByAsc("id");
		Page<ResumeDetails> page = new Page<>(pageRequest.getPageNum(),pageRequest.getPageSize());
		page = (Page)resumeDetailsDao.selectPage(page, queryWrapper);
		return page;
	}

}