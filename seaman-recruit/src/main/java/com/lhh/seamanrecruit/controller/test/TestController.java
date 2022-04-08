package com.lhh.seamanrecruit.controller.test;

import com.lhh.seamanrecruit.entity.Test;
import com.lhh.seamanrecruit.service.tset.TestService;
import com.lhh.seamanrecruit.utils.QiNiuUtil;
import com.lhh.seamanrecruit.utils.RedisUtils;
import com.lhh.seamanrecruit.utils.Result;
import com.lhh.seamanrecruit.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @Author: yslong
 * @Date: 2022/3/14 11:06
 * @Description: 测试controller
 */
//@Api(value = "测试接口",tags = "用户管理接口",description = "用户测试接口")
@Api(tags = "测试接口")
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private QiNiuUtil qiNiuUtil;

    @Autowired
    private RedisUtils redisUtils;


    @ApiOperation("查询所有用户-测试")
//    @ApiImplicitParam(name = "test", value = "查询用户")
    @GetMapping("/queryAll")
    public Result queryAll() {
//        int a = 1/0;
        redisUtils.set("789789", "6666");
        String cacheObject = (String) redisUtils.get("789789");
//        log.info(cacheObject);
        List<Test> res = testService.queryAll();
        return ResultUtils.success(res);
    }


    @ApiOperation("文件上传-测试")
    @PostMapping("/pictureTest")
    public Result pictureTest(MultipartFile file) {
        qiNiuUtil.uploadMultipartFile(file, file.getOriginalFilename(), true);
        return ResultUtils.success();
    }

    @ApiOperation("获取文件地址-测试")
    @PostMapping("/fileUrl")
    public Result pictureTest(String fileName) {
        String s = null;
        try {
            s = qiNiuUtil.fileUrl(fileName);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return ResultUtils.success(s);
    }


}
