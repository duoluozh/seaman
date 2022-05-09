package com.lhh.seamanrecruit.service.company.impl;

import com.lhh.seamanrecruit.dao.PositionDao;
import com.lhh.seamanrecruit.dto.company.CompanyDto;
import com.lhh.seamanrecruit.entity.Company;
import com.lhh.seamanrecruit.dao.CompanyDao;
import com.lhh.seamanrecruit.service.company.CompanyService;
import com.lhh.seamanrecruit.utils.CopyUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public CompanyDto insert(CompanyDto entity) {
        Company company = CopyUtils.copy(entity, Company.class);
        Long userId = company.getUserId();
        if (userId == null) {
            throw new RuntimeException("userId不能为空");
        }
        if (companyDao.selectByUserId(userId) != null) {
            throw new RuntimeException("你的名下已经有公司啦！去发布职位吧。");
        }
        company.setStatusFlag(0L);
        companyDao.insert(company);
        entity = CopyUtils.copy(company, CompanyDto.class);
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
        Map<String, Object> params = new HashMap<>();
        for (Long id : ids) {
            params.put("company_id", id);
            positionDao.deleteByMap(params);
        }
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
     * @param dto 筛选条件
     * @return 查询结果
     */
    @Override
    public Page<Company> queryByPage(CompanyDto dto) {
        String companyName = dto.getCompanyName();
        String representative = dto.getRepresentative();
        String companyType = dto.getCompanyType();
        String socialCreditCode = dto.getSocialCreditCode();
        List<Long> statusFlag = dto.getStatusFlag();
        QueryWrapper<Company> queryWrapper = new QueryWrapper<>();
        if (!CollectionUtils.isEmpty(statusFlag)) {
            queryWrapper.in("status_flag", statusFlag);
        }
        if (StringUtils.isNotBlank(companyName)) {
            queryWrapper.like("company_name", companyName);
        }
        if (StringUtils.isNotBlank(representative)) {
            queryWrapper.like("representative", representative);
        }
        if (StringUtils.isNotBlank(socialCreditCode)) {
            queryWrapper.like("social_credit_code", socialCreditCode);
        }
        if (StringUtils.isNotBlank(companyType)) {
            queryWrapper.like("company_type", companyType);
        }
        queryWrapper.orderByAsc("id");
        Page<Company> page = new Page<>(dto.getPageNum(), dto.getPageSize());
        page = (Page) companyDao.selectPage(page, queryWrapper);
        return page;
    }

    @Override
    public List<Company> queryByUserId(Long userId) {
        QueryWrapper<Company> queryWrapper = new QueryWrapper<>();
        Map<String, Object> params = new HashMap<>();
        params.put("user_id", userId);
        queryWrapper.allEq(params);

        return companyDao.selectList(queryWrapper);
    }

}