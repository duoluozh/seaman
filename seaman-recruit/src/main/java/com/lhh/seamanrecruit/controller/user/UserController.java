package com.lhh.seamanrecruit.controller.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.lhh.seamanrecruit.entity.User;
import com.lhh.seamanrecruit.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * 用户表控制层
 *
 * @author  yslong
 * @date 2022-04-07 20:50:10
 */
@Api(tags = "用户")
@RestController
@RequestMapping("user")
public class UserController {


    @Autowired
    private UserService userService;

    /**
     * 分页查询
     *
     * @param pageRequest 分页对象
     * @return 查询结果
     *
     */
    @PostMapping("queryByPage")
    @ApiOperation("分页查询用户")
    public ResponseEntity<Page<User>> queryByPage(@RequestBody User user, @RequestBody PageRequest pageRequest) {
        return ResponseEntity.ok(userService.queryByPage(user, pageRequest));
        }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("通过id查询用户")
    public ResponseEntity<User> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.queryById(id));
        }

    /**
     * 新增数据
     *
     * @param user 用户实体
     * @return 新增结果
     */
    @PostMapping("add")
    @ApiOperation("新增用户")
    public ResponseEntity<User> add(@RequestBody User user) {
        return ResponseEntity.ok(userService.insert(user));
        }

    /**
     * 根据id修改数据
     *
     * @param user 用户实体
     * @return 编辑结果
     */
    @PostMapping("updateById")
    @ApiOperation("根据id修改")
    public ResponseEntity<User> updateById(@RequestBody User user) {
        return ResponseEntity.ok(userService.updateById(user));
        }

    /**
     * 删除数据
     *
     * @param ids 主键集合
     * @return 删除是否成功
     */
    @PostMapping("delete")
    @ApiOperation("根据ids删除")
    public ResponseEntity<Boolean> deleteById(@RequestBody List<Long> ids) {
        return ResponseEntity.ok(userService.deleteById(ids));
        }

}
