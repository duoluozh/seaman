package com.lhh.seamanrecruit.constant;

/**
 * @Author: yslong
 * @Date: 2022/4/9 16:08
 * @Description: 常量类
 */
public class Constant {

    /**
     * token过期时间（毫秒）
     */
    public static final Integer TOKEN_EXPIRE_TIME = 3600000;

    /**
     * 验证码过期时间（毫秒）
     */
    public static final Integer VERIFICATION_CODE_TIME = 300000;

    /**
     * 邮件发送成功
     */
    public static final String EMAIL_SUCCESS = "邮件发送成功！";

    /**
     * 邮件发送失败
     */
    public static final String EMAIL_ERROR = "邮件发送失败！";

    /**
     * 密码错误
     */
    public static final String PASSWORD_ERROR = "密码错误！";

    /**
     * 密码不能为空
     */
    public static final String PASSWORD_NULL = "密码不能为空！";

    /**
     * 请先输入用户名
     */
    public static final String USERNAME_NULL = "请先输入用户名！";

    /**
     * 请先输入验证码
     */
    public static final String VERIFICATIONCODE_NULL = "请先输入验证码";

    /**
     * 邮箱不能为空
     */
    public static final String EMAIL_NULL = "邮箱不能为空！";

    /**
     * 用户名不存在
     */
    public static final String USERNAME_NOT_EXIST = "用户名不存在！";

    /**
     * 用户名被占用
     */
    public static final String USERNAME_OCCUPY = "用户名已被占用！";

    /**
     * 验证码错误
     */
    public static final String VERIFICATIONCODE_ERROR = "验证码错误";

    /**
     * 密码不符合规则
     */
    public static final String PASSWORD_NOT_RULE = "密码不符合规则,请更改后重试";

    /**
     * 邮箱绑定其他用户
     */
    public static final String EMAIL_OCCUPY = "邮箱绑定其他用户！";

    /**
     * 验证码
     */
    public static final String EMAIL_CODE = "邮箱验证";

    /**
     * 邮箱验证信息
     */
    public static final String EMAIL_IS_CODE = "验证码为:";

    /**
     * 忘记密码邮箱验证码redis key
     */
    public static final String EMAIL_CODE_KEY = "EMAIL.CODE.";

}
