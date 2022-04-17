package com.lhh.seamanrecruit.service.position.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhh.seamanrecruit.constant.Constant;
import com.lhh.seamanrecruit.dao.CompanyDao;
import com.lhh.seamanrecruit.dao.UserDao;
import com.lhh.seamanrecruit.dao.UserPositionDao;
import com.lhh.seamanrecruit.dto.position.PositionCompanyDto;
import com.lhh.seamanrecruit.dto.position.PositionDto;
import com.lhh.seamanrecruit.entity.Company;
import com.lhh.seamanrecruit.entity.Position;
import com.lhh.seamanrecruit.dao.PositionDao;
import com.lhh.seamanrecruit.entity.User;
import com.lhh.seamanrecruit.entity.UserPosition;
import com.lhh.seamanrecruit.service.position.PositionService;
import com.lhh.seamanrecruit.utils.Result;
import com.lhh.seamanrecruit.utils.UserUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhh.seamanrecruit.dto.BaseQueryDto;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Autowired
	private CompanyDao companyDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserPositionDao userPositionDao;

	/**
	 * 新增数据
	 *
	 * @param entity 实例对象
	 * @return 实例对象
	 */
	@Override
	@Transactional
	public Result insert(Position entity, Long userId) {
		//查询当前用户对应的公司id
		Company company = companyDao.selectByUserId(userId);
		if (null == company){
			return Result.error(Constant.POSITION_USER_NOT_COMPANY_USER);
		}
		entity.setCompanyId(company.getId());
		entity.setCompanyName(company.getCompanyName());
		entity.setStatusFlag("0");
		entity.setUpdateTime(LocalDateTime.now());
		positionDao.insert(entity);
		return Result.success(entity);
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
		Long userId = UserUtils.getLoginUserId();
		Company company = companyDao.selectByUserId(userId);
		//该用户对应的企业id不一致
		if (entity.getCompanyId().equals(company.getId())){
			return null;
		}
		//如果更新时更新了发布状态，则更新发布时间
		if (!StringUtils.isBlank(entity.getStatusFlag()) && entity.getStatusFlag().equals("1")){
			entity.setReleaseTime(LocalDateTime.now());
		}
		positionDao.updateById(entity);
		return positionDao.selectById(entity.getId());
	}

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	@Override
	public PositionCompanyDto queryById(Long id) {
		PositionCompanyDto positionCompanyDto = positionDao.selectByPositionCompany(id);

		Long userId = UserUtils.getLoginUserId();
		LocalDateTime now = LocalDateTime.now();
		//查询简历是否在两个月内被投递
		LocalDateTime dateTime = now.minus(60, ChronoUnit.DAYS);
		UserPosition userPosition = userPositionDao.selectUserPosition(userId,id,dateTime);
		if (null != userPosition){
			positionCompanyDto.setDeliveryFlag("1");
		} else {
			positionCompanyDto.setDeliveryFlag("0");
		}
		return positionCompanyDto;
	}

	/**
	 * 分页查询
	 *
	 * @param entity 筛选条件
	 * @param pageRequest 分页对象
	 * @return 查询结果
	 */
	@Override
	public PageInfo<PositionDto> queryByPage(Position entity, BaseQueryDto pageRequest,Long userId) {
		//查询当前用户
		User user = userDao.selectById(userId);
		if (user.getUserType() == 0){
			//船员
			entity.setStatusFlag("1");
		} else if (user.getUserType() == 1){
			//企业
			Company company = companyDao.selectByUserId(userId);
			entity.setCompanyId(company.getId());
		}
		PageHelper.startPage(pageRequest.getPageNum(),pageRequest.getPageSize());
		List<PositionDto> positionDtos = positionDao.selectPageList(entity);

		PageInfo<PositionDto> userInfoPage = new PageInfo<PositionDto>(positionDtos);
		return userInfoPage;
	}

	/**
	 * 简历投递
	 *
	 * @param id 职位id
	 * @param userId   用户id
	 * @return 投递结果
	 */
	@Override
	public Map<String,String> insertDelivery(Long id, Long userId) {
		UserPosition userPosition = new UserPosition();
		userPosition.setPositionId(id);
		userPosition.setPositionId(userId);
		userPosition.setCreatedTime(LocalDateTime.now());
		userPositionDao.insert(userPosition);
		Map<String,String> map = new HashMap<>();
		map.put("deliveryFlag","1");
		return map;
	}

}