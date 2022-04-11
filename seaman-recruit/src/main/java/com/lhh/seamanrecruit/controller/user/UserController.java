package com.lhh.seamanrecruit.controller.user;

import com.lhh.seamanrecruit.constant.Constant;
import com.lhh.seamanrecruit.constant.Regulars;
import com.lhh.seamanrecruit.dto.user.LoginReqDto;
import com.lhh.seamanrecruit.dto.user.LoginResDto;
import com.lhh.seamanrecruit.dto.user.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.lhh.seamanrecruit.entity.User;
import com.lhh.seamanrecruit.service.user.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.lhh.seamanrecruit.dto.BaseQueryDto;
import com.lhh.seamanrecruit.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 用户控制层
 *
 * @author yslong
 * @date 2022-04-08 13:40:42
 */
@Api(tags = "用户")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     *
     * @param userDto 用户实体
     * @return 新增结果
     */
    @PostMapping("/register")
    @ApiOperation("用户注册")
    public Result register(@RequestBody UserDto userDto) {
        if (StringUtils.isBlank(userDto.getUserName())) {
            return Result.error(Constant.USERNAME_NULL);
        }
        if (StringUtils.isBlank(userDto.getPassword())) {
            return Result.error(Constant.PASSWORD_NULL);
        }
        if (StringUtils.isBlank(userDto.getEmail())) {
            return Result.error(Constant.EMAIL_NULL);
        }
        return Result.success(userService.register(userDto));
    }

    /**
     * 用户登录
     *
     * @param loginReqDto 用户实体
     * @return 新增结果
     */
    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Result login(@RequestBody LoginReqDto loginReqDto, HttpServletResponse response) {
        if (StringUtils.isBlank(loginReqDto.getUserName())) {
            return Result.error(Constant.USERNAME_NULL);
        }
        if (StringUtils.isBlank(loginReqDto.getPassword())) {
            return Result.error(Constant.PASSWORD_NULL);
        }
        LoginResDto res = userService.login(loginReqDto);
        // 将token存入cookies
        Cookie tokenCookie = new Cookie("token", res.getToken());
        // 关闭浏览器就失效
        tokenCookie.setMaxAge(-1);
        response.addCookie(tokenCookie);
        return Result.success(res);
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
        return Result.success(userService.deleteById(ids));
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
        return Result.success(userService.updateById(user));
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
        return Result.success(userService.queryById(id));
    }

    /**
     * 分页查询
     *
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping("/queryByPage")
    @ApiOperation("分页查询用户")
    public Result queryByPage(User user, BaseQueryDto pageRequest) {
        return Result.success(userService.queryByPage(user, pageRequest));
    }

    /**
     * 忘记密码
     *
     * @param dto 用户名
     * @return 查询结果
     */
    @PostMapping("/forgetPassword")
    @ApiOperation("忘记密码")
    public Result forgetPassword(@RequestBody LoginReqDto dto ) {
        if (StringUtils.isBlank(dto.getUserName()) ){
            throw new RuntimeException(Constant.USERNAME_NULL);
        }
        if (StringUtils.isBlank(dto.getPassword())){
            throw new RuntimeException(Constant.PASSWORD_NULL);
        }
        if (StringUtils.isBlank(dto.getVerificationCode())){
            throw new RuntimeException(Constant.VERIFICATIONCODE_NULL);
        }
        if (!dto.getPassword().matches(Regulars.PASSWORD_REGULAR)){
            //正则校验
            throw new RuntimeException(Constant.PASSWORD_NOT_RULE);
        }
        return userService.forgetPassword(dto);
    }

    /**
     * 发送邮箱验证码
     *
     * @param userName 用户名
     * @return 发送结果
     */
    @GetMapping("/sendVerificationCode")
    @ApiOperation("发送邮箱验证码")
    public Result sendVerificationCode(@RequestParam("userName") String userName) {
        if (StringUtils.isBlank(userName)){
            throw new RuntimeException(Constant.USERNAME_NULL);
        }
        try {
            userService.verificationCode(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success(userName);
    }

}
