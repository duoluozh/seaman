package com.lhh.seamanrecruit.controller.position;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.lhh.seamanrecruit.entity.Position;
import com.lhh.seamanrecruit.service.position.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import com.lhh.seamanrecruit.dto.BaseQueryDto;
import com.lhh.seamanrecruit.utils.Result;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * 招聘控制层
 *
 * @author  yslong
 * @date 2022-04-12 14:09:33
 */
@Api(tags = "招聘")
@RestController
@RequestMapping("/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    /**
     * 新增数据
     *
     * @param position 招聘实体
     * @return 新增结果
     */
    @PostMapping("/add")
    @ApiOperation("新增招聘")
    public Result add(@RequestBody Position position) {
        return Result.success(positionService.insert(position));
    }

    /**
     * 删除数据
     *
     * @param ids 主键集合
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    @ApiOperation("根据ids删除招聘")
    public Result deleteById(@RequestBody List<Long> ids) {
        return Result.success(positionService.deleteById(ids));
    }

    /**
     * 根据id修改数据
     *
     * @param position 招聘实体
     * @return 编辑结果
     */
    @PostMapping("/updateById")
    @ApiOperation("根据id修改招聘")
    public Result updateById(@RequestBody Position position) {
        return Result.success(positionService.updateById(position));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    @ApiOperation("通过id查询招聘")
    public Result queryById(@PathVariable("id") Long id) {
        return Result.success(positionService.queryById(id));
    }

    /**
     * 分页查询
     *
     * @param pageRequest 分页对象
     * @return 查询结果
     *
     */
    @GetMapping("/queryByPage")
    @ApiOperation("分页查询招聘")
    public Result queryByPage(Position position, BaseQueryDto pageRequest) {
        return Result.success(positionService.queryByPage(position, pageRequest));
    }

}
