package com.lhh.seamanrecruit.controller.user;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhh.seamanrecruit.constant.Constant;
import com.lhh.seamanrecruit.constant.Regulars;
import com.lhh.seamanrecruit.dto.user.*;
import com.lhh.seamanrecruit.utils.UserUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.lhh.seamanrecruit.entity.User;
import com.lhh.seamanrecruit.service.user.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.lhh.seamanrecruit.utils.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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
     * @param registerDto 注册
     * @return 新增结果
     */
    @PostMapping("/register")
    @ApiOperation("用户注册")
    public Result<User> register(@RequestBody RegisterDto registerDto) {
        Integer userType = registerDto.getUserType();
        if (userType == null) {
            // 用户类型不能为空
            throw new RuntimeException(Constant.USERNAME_TYPE_NULL);
        }
        if (StringUtils.isBlank(registerDto.getUserName())) {
            // 用户名不能为空
            throw new RuntimeException(Constant.USERNAME_NULL);
        }
        String password = registerDto.getPassword();
        if (StringUtils.isBlank(password)) {
            //密码不能为空
            throw new RuntimeException(Constant.PASSWORD_NULL);
        }
        if (!password.matches(Regulars.PASSWORD_REGULAR)) {
            //正则校验
            throw new RuntimeException(Constant.PASSWORD_NOT_RULE);
        }
        if (StringUtils.isBlank(registerDto.getEmail())) {
            // 邮箱不能为空
            throw new RuntimeException(Constant.EMAIL_NULL);
        }
        return Result.success(userService.register(registerDto));
    }

    /**
     * 用户登录
     *
     * @param loginReqDto 用户实体
     * @return 新增结果
     */
    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Result<LoginResDto> login(@RequestBody @Valid LoginReqDto loginReqDto, HttpServletResponse response) {
        if (StringUtils.isBlank(loginReqDto.getUserName())) {
            throw new RuntimeException(Constant.USERNAME_NULL);
        }
        if (StringUtils.isBlank(loginReqDto.getPassword())) {
            throw new RuntimeException(Constant.PASSWORD_NULL);
        }
        LoginResDto res = userService.login(loginReqDto);
        // 将token存入cookies
        Cookie tokenCookie = new Cookie(Constant.TOKEN, res.getToken());
        // 关闭浏览器就失效
        tokenCookie.setPath("/");
        tokenCookie.setMaxAge(Constant.TOKEN_EXPIRE_TIME);
        response.addCookie(tokenCookie);
        return Result.success(res);
    }

    /**
     * 修改密码
     *
     * @param reqDto
     * @return 修改结果
     */
    @PostMapping("/updatePassword")
    @ApiOperation("修改密码")
    public Result updatePassword(@RequestBody @Valid UpdatePasswordReqDto reqDto) {
        String userName = reqDto.getUserName();
        if (StringUtils.isNotBlank(userName) && !userName.equals(UserUtils.getLoginUserName())) {
            return Result.error(Constant.USER_ERROR);
        }
        if (StringUtils.isBlank(reqDto.getOldPassword())) {
            return Result.error(Constant.OLD_PASSWORD_NULL);
        }
        String newPassword = reqDto.getNewPassword();
        if (StringUtils.isBlank(newPassword)) {
            return Result.error(Constant.NEW_PASSWORD_NULL);
        }
        if (!newPassword.matches(Regulars.PASSWORD_REGULAR)) {
            //正则校验
            throw new RuntimeException(Constant.PASSWORD_NOT_RULE);
        }
        if (userService.updatePassword(reqDto)) {
            return Result.success();
        } else {
            return Result.error();
        }
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
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    @ApiOperation("通过id查询用户")
    public Result<User> queryById(@PathVariable("id") Long id) {
        return Result.success(userService.queryById(id));
    }

    /**
     * 分页查询
     *
     * @param user 查询条件
     * @return 查询结果
     */
    @PostMapping("/queryByPage")
    @ApiOperation("分页查询用户")
    public Result<Page<User>> queryByPage(@RequestBody UserDto user) {
        return Result.success(userService.queryByPage(user));
    }

    /**
     * 忘记密码
     *
     * @param dto 用户名
     * @return 查询结果
     */
    @PostMapping("/forgetPassword")
    @ApiOperation("忘记密码")
    public Result forgetPassword(@RequestBody LoginReqDto dto) {
        if (StringUtils.isBlank(dto.getUserName())) {
            throw new RuntimeException(Constant.USERNAME_NULL);
        }
        if (StringUtils.isBlank(dto.getPassword())) {
            throw new RuntimeException(Constant.PASSWORD_NULL);
        }
        if (StringUtils.isBlank(dto.getVerificationCode())) {
            throw new RuntimeException(Constant.VERIFICATION_CODE_NULL);
        }
        if (!dto.getPassword().matches(Regulars.PASSWORD_REGULAR)) {
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
        if (StringUtils.isBlank(userName)) {
            throw new RuntimeException(Constant.USERNAME_NULL);
        }
        try {
            userService.verificationCode(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.success(userName);
    }

    /**
     * 查询当前登录用户信息
     *
     * @return 单条数据
     */
    @GetMapping("/currentLoginUser")
    @ApiOperation("查询当前登录用户信息")
    public Result currentLoginUser() {
        Long userId = UserUtils.getLoginUserId();
        return Result.success(userService.queryById(userId));
    }

    /**
     * 头像上传
     *
     * @param file 头像文件
     * @return 单条数据
     */
    @PostMapping(value = "/pictureUpload")
    @ApiOperation("头像上传")
    public Result pictureUpload(MultipartFile file) {
        Long userId = UserUtils.getLoginUserId();
        return userService.pictureUpload(userId, file);
    }
}
