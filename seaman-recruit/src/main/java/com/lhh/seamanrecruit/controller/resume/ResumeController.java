package com.lhh.seamanrecruit.controller.resume;

import com.lhh.seamanrecruit.constant.Constant;
import com.lhh.seamanrecruit.dto.resume.ResumeAddDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.lhh.seamanrecruit.entity.Resume;
import com.lhh.seamanrecruit.service.resume.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import com.lhh.seamanrecruit.dto.BaseQueryDto;
import com.lhh.seamanrecruit.utils.Result;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * 简历控制层
 *
 * @author  yslong
 * @date 2022-04-12 14:10:30
 */
@Api(tags = "简历")
@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    /**
     * 新增数据
     *
     * @param resume 简历新增实体
     * @return 新增结果
     */
    @PostMapping("/add")
    @ApiOperation("新增简历")
    public Result add(@RequestBody ResumeAddDto resume) {
        return Result.success(resumeService.insert(resume));
    }

    /**
     * 删除数据
     *
     * @param ids 主键集合
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    @ApiOperation("根据ids删除简历")
    public Result deleteById(@RequestBody List<Long> ids) {
        return Result.success(resumeService.deleteById(ids));
    }

    /**
     * 根据id修改数据
     *
     * @param resume 简历实体
     * @return 编辑结果
     */
    @PostMapping("/updateById")
    @ApiOperation("根据id修改简历")
    public Result updateById(@RequestBody ResumeAddDto resume) {
        ResumeAddDto resumeAddDto = resumeService.updateById(resume);
        if (null == resumeAddDto){
            return Result.error(Constant.NOT_UPDATE_JURISDICTION);
        }
        return Result.success(resumeAddDto);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    @ApiOperation("通过id查询简历")
    public Result queryById(@PathVariable("id") Long id) {
        return Result.success(resumeService.queryById(id));
    }

    /**
     * 分页查询
     *
     * @param pageRequest 分页对象
     * @return 查询结果
     *
     */
    @GetMapping("/queryByPage")
    @ApiOperation("分页查询简历")
    public Result queryByPage(Resume resume, BaseQueryDto pageRequest) {
        return Result.success(resumeService.queryByPage(resume, pageRequest));
    }

}
