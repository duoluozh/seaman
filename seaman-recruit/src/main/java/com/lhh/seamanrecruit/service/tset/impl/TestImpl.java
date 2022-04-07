package com.lhh.seamanrecruit.service.tset.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lhh.seamanrecruit.dao.TestDao;
import com.lhh.seamanrecruit.entity.Test;
import com.lhh.seamanrecruit.service.tset.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yslong
 * @Date: 2022/3/14 14:43
 * @Description:
 */
@Service
@Slf4j
public class TestImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public List<Test> queryAll() {
        QueryWrapper<Test> queryWrapper = new QueryWrapper<>();
        return testDao.selectList(queryWrapper);
    }
}
