package com.lhh.seamanrecruit.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.lhh.seamanrecruit.entity.User;
import com.lhh.seamanrecruit.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.lhh.seamanrecruit.dto.BaseQueryDto;
import com.lhh.seamanrecruit.utils.Result;
import com.lhh.seamanrecruit.utils.ResultUtils;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * 用户表控制层
 *
 * @author  yslong
 * @date 2022-04-08 10:50:08
 */
@Api(tags = "用户")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 新增数据
     *
     * @param user 用户实体
     * @return 新增结果
     */
    @PostMapping("/add")
    @ApiOperation("新增用户")
    public Result add(@RequestBody User user) {
        return ResultUtils.ok().data(userService.insert(user));
    }

    /**
     * 删除数据
     *
     * @param ids 主键集合
     * @return 删除是否成功
     */
    @PostMapping("/delete")
    @ApiOperation("根据ids删除")
    public Result deleteById(@RequestBody List<Long> ids) {
        return ResultUtils.ok().data(userService.deleteById(ids));
    }

    /**
     * 根据id修改数据
     *
     * @param user 用户实体
     * @return 编辑结果
     */
    @PostMapping("/updateById")
    @ApiOperation("根据id修改")
    public Result updateById(@RequestBody User user) {
        return ResultUtils.ok().data(userService.updateById(user));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    @ApiOperation("通过id查询用户")
    public Result queryById(@PathVariable("id") Long id) {
        return ResultUtils.ok().data(userService.queryById(id));
    }

    /**
     * 分页查询
     *
     * @param pageRequest 分页对象
     * @return 查询结果
     *
     */
    @GetMapping("/queryByPage")
    @ApiOperation("分页查询用户")
    public Result queryByPage(User user, BaseQueryDto pageRequest) {
        return ResultUtils.ok().data(userService.queryByPage(user, pageRequest));
    }

}
