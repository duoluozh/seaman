package com.lhh.seamanrecruit.service.resume.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lhh.seamanrecruit.dao.ResumeDetailsDao;
import com.lhh.seamanrecruit.dao.UserDao;
import com.lhh.seamanrecruit.dto.resume.ResumeAddDto;
import com.lhh.seamanrecruit.dto.resume.ResumeDto;
import com.lhh.seamanrecruit.entity.Resume;
import com.lhh.seamanrecruit.dao.ResumeDao;
import com.lhh.seamanrecruit.entity.ResumeDetails;
import com.lhh.seamanrecruit.entity.User;
import com.lhh.seamanrecruit.service.resume.ResumeService;
import com.lhh.seamanrecruit.utils.CopyUtils;
import com.lhh.seamanrecruit.utils.UserUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 简历服务实现类
 *
 * @author yslong
 * @date 2022-04-12 14:10:30
 */
@Slf4j
@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeDao resumeDao;

    @Autowired
    private ResumeDetailsDao resumeDetailsDao;

    @Autowired
    private UserDao userDao;

    /**
     * 新增数据
     *
     * @param entity 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public ResumeAddDto insert(ResumeAddDto entity) {
        Long userId = UserUtils.getLoginUserId();
        entity.setUserId(userId);
        Resume resume = CopyUtils.copy(entity, Resume.class);
        resumeDao.insert(resume);
        List<ResumeDetails> resumeDetails = entity.getResumeDetails();
        if (null != resumeDetails && resumeDetails.size() > 0) {
            for (ResumeDetails resumeDetail : resumeDetails) {
                resumeDetail.setMasterId(resume.getId());
                resumeDetailsDao.insert(resumeDetail);
            }
        }
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
        return resumeDao.deleteBatchIds(ids) > 0;
    }

    /**
     * 修改数据
     *
     * @param entity 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public ResumeAddDto updateById(ResumeAddDto entity) {
        Long userId = UserUtils.getLoginUserId();
        User user = userDao.selectById(userId);
        if (user.getUserType() == 1) {
            return null;
        }
        Resume resume = CopyUtils.copy(entity, Resume.class);
        resumeDao.updateById(resume);

        List<ResumeDetails> resumeDetails = entity.getResumeDetails();
        if (null != resumeDetails && resumeDetails.size() > 0) {
            for (ResumeDetails resumeDetail : resumeDetails) {
                resumeDetailsDao.updateById(resumeDetail);
            }
        }
        return queryById(entity.getId());
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ResumeAddDto queryById(Long id) {
        //查询简历主表信息
        Resume resume = resumeDao.selectById(id);
        if (resume == null) {
            return null;
        }
        ResumeAddDto resumeAddDto = CopyUtils.copy(resume, ResumeAddDto.class);
        //查询明细集合
        List<ResumeDetails> resumeAddDtos = resumeDetailsDao.selectByMasterId(id);
        resumeAddDto.setResumeDetails(resumeAddDtos);
        return resumeAddDto;
    }

    /**
     * 分页查询
     *
     * @param dto      筛选条件
     * @return 查询结果
     */
    @Override
    public Page<Resume> queryByPage(ResumeDto dto) {
        QueryWrapper<Resume> queryWrapper = new QueryWrapper<>();
        String education = dto.getEducation();
        String certificateLevel = dto.getCertificateLevel();
        String monthlySalary = dto.getMonthlySalary();
        if (StringUtils.isNotBlank(education)){
            queryWrapper.like("education",education);
        }
        if (StringUtils.isNotBlank(certificateLevel)){
            queryWrapper.like("certificate_level",certificateLevel);
        }
        if (StringUtils.isNotBlank(monthlySalary)){
            Map<String,Object> params = new HashMap<>();
            params.put("certificate_level",monthlySalary);
            queryWrapper.allEq(params);
        }
        if (StringUtils.isNotBlank(monthlySalary)){
            Map<String,Object> params = new HashMap<>();
            params.put("certificate_level",monthlySalary);
            queryWrapper.allEq(params);
        }
        Page<Resume> page = new Page<>(dto.getPageNum(), dto.getPageSize());
        return (Page)resumeDao.selectPage(page,queryWrapper);
    }

    @Override
    public Page<Resume> queryResumePage(ResumeDto resume) {
        resume.setUserId(UserUtils.getLoginUserId());
//        PageHelper.startPage(resume.getPageNum(), resume.getPageSize());
//        List<ResumeDto> positionDtos = resumeDao.queryResumePage(resume);
        QueryWrapper<Resume> queryWrapper = new QueryWrapper<>();
        String education = resume.getEducation();
        String certificateLevel = resume.getCertificateLevel();
        String monthlySalary = resume.getMonthlySalary();
        if (StringUtils.isNotBlank(education)){
            queryWrapper.like("education",education);
        }
        if (StringUtils.isNotBlank(certificateLevel)){
            queryWrapper.like("certificate_level",certificateLevel);
        }
        if (StringUtils.isNotBlank(monthlySalary)){
            Map<String,Object> params = new HashMap<>();
            params.put("certificate_level",monthlySalary);
            queryWrapper.allEq(params);
        }
        if (StringUtils.isNotBlank(monthlySalary)){
            Map<String,Object> params = new HashMap<>();
            params.put("certificate_level",monthlySalary);
            queryWrapper.allEq(params);
        }
        Page<Resume> page = new Page<>(resume.getPageNum(), resume.getPageSize());
        return (Page)resumeDao.selectPage(page,queryWrapper);
    }

    @Override
    public ResumeAddDto queryByUserId(Long loginUserId) {
        //查询简历主表信息
        Resume resume = resumeDao.selectByUserId(loginUserId);
        if (resume == null) {
            return null;
        }
        ResumeAddDto resumeAddDto = CopyUtils.copy(resume, ResumeAddDto.class);
        //查询明细集合
        List<ResumeDetails> resumeAddDtos = resumeDetailsDao.selectByMasterId(resume.getId());
        resumeAddDto.setResumeDetails(resumeAddDtos);
        return resumeAddDto;
    }

}