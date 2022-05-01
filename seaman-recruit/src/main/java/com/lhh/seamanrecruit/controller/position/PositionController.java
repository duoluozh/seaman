package com.lhh.seamanrecruit.controller.position;

import com.lhh.seamanrecruit.constant.Constant;
import com.lhh.seamanrecruit.dto.position.PositionCompanyDto;
import com.lhh.seamanrecruit.dto.position.PositionDto;
import com.lhh.seamanrecruit.enums.PositionEnum;
import com.lhh.seamanrecruit.utils.UserUtils;
import io.swagger.annotations.Api;
import com.github.pagehelper.PageInfo;
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
 * @author yslong
 * @date 2022-04-12 14:09:33
 */
@Api(tags = "招聘职位")
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
    public Result<PositionDto> add(@RequestBody PositionDto position) {
        return Result.success(positionService.insert(position, UserUtils.getLoginUserId()));
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
    public Result<Position> updateById(@RequestBody Position position) {
        Position posit = positionService.updateById(position);
        if (null == posit) {
            throw new RuntimeException((Constant.NOT_UPDATE_JURISDICTION));
        }
        return Result.success(posit);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/queryById")
    @ApiOperation("通过id查询招聘明细信息")
    public Result<PositionCompanyDto> queryById(@RequestParam("id") Long id) {
        return Result.success(positionService.queryById(id));
    }

    /**
     * 分页查询
     *
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @PostMapping("/queryByPage")
    @ApiOperation("分页查询招聘")
    public Result<PageInfo<PositionDto>> queryByPage(Position position, BaseQueryDto pageRequest) {
        Long userId = UserUtils.getLoginUserId();
        return Result.success(positionService.queryByPage(position, pageRequest, userId));
    }

    /**
     * 简历投递
     *
     * @param id 职位id
     * @return 查询结果
     */
    @GetMapping("/delivery")
    @ApiOperation("简历投递")
    public Result delivery(@RequestParam("id") Long id) {
        Long userId = UserUtils.getLoginUserId();
        return Result.success(positionService.insertDelivery(id, userId));
    }

    /**
     * 职位下拉框
     *
     * @return 职位名称集合
     *
     */
    @GetMapping("/positionList")
    @ApiOperation("职位下拉框")
    public Result<List<String>> positionList() {
        return Result.success(PositionEnum.getPositionList());
    }

}
