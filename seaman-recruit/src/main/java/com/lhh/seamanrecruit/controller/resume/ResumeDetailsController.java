package com.lhh.seamanrecruit.controller.resume;

import com.lhh.seamanrecruit.dto.BaseQueryDto;
import com.lhh.seamanrecruit.entity.ResumeDetails;
import com.lhh.seamanrecruit.service.resume.ResumeDetailsService;
import com.lhh.seamanrecruit.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 简历明细控制层
 *
 * @author  yslong
 * @date 2022-04-12 14:10:45
 */
@Api(tags = "简历明细")
@RestController
@RequestMapping("/resumeDetails")
public class ResumeDetailsController {

    @Autowired
    private ResumeDetailsService resumeDetailsService;

    /**
     * 新增数据
     *
     * @param resumeDetails 简历明细实体
     * @return 新增结果
     */
    @PostMapping("/add")
    @ApiOperation("新增简历明细")
    public Result add(@RequestBody ResumeDetails resumeDetails) {
        return Result.success(resumeDetailsService.insert(resumeDetails));
    }

    /**
     * 删除数据
     *
     * @param ids 主键集合
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    @ApiOperation("根据ids删除简历明细")
    public Result deleteById(@RequestBody List<Long> ids) {
        return Result.success(resumeDetailsService.deleteById(ids));
    }

    /**
     * 根据id修改数据
     *
     * @param resumeDetails 简历明细实体
     * @return 编辑结果
     */
    @PostMapping("/updateById")
    @ApiOperation("根据id修改简历明细")
    public Result updateById(@RequestBody ResumeDetails resumeDetails) {
        return Result.success(resumeDetailsService.updateById(resumeDetails));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    @ApiOperation("通过id查询简历明细")
    public Result queryById(@PathVariable("id") Long id) {
        return Result.success(resumeDetailsService.queryById(id));
    }

    /**
     * 分页查询
     *
     * @param pageRequest 分页对象
     * @return 查询结果
     *
     */
    @GetMapping("/queryByPage")
    @ApiOperation("分页查询简历明细")
    public Result queryByPage(ResumeDetails resumeDetails, BaseQueryDto pageRequest) {
        return Result.success(resumeDetailsService.queryByPage(resumeDetails, pageRequest));
    }

}
