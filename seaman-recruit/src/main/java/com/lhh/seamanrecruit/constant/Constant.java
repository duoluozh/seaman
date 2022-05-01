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
     * token
     */
    public static final String TOKEN = "token";

    /**
     * token为空
     */
    public static final String TOKEN_ISNULL = "toke-isnull";

    /**
     * 用户不存在
     */
    public static final String USER_ISNULL = "user-isnull";

    /**
     * token异常/无效token
     */
    public static final String ERROR_TOKEN = "error-token";

    /**
     * 操作失败
     */
    public static final String RESULT_ERROR = "操作失败！";

    /**
     * 操作成功
     */
    public static final String RESULT_SUCCESS = "操作成功！";

    /**
     * 获取授权失败
     */
    public static final String AUTHORITY_ERROR = "获取授权失败！";

    /**
     * 邮件发送成功
     */
    public static final String EMAIL_SUCCESS = "邮件发送成功！";

    /**
     * 邮件发送失败
     */
    public static final String EMAIL_ERROR = "邮件发送失败！";

    /**
     * 请先进行登录
     */
    public static final String LOGIN_FIRST = "请先进行登录！";

    /**
     * 用户不存在，请重新登录
     */
    public static final String USERNAME_NOT_EXIST_LOGIN = "用户不存在，请重新登录！";

    /**
     * 无效登录，请重新登录！
     */
    public static final String INVALID_LOGIN = "登录信息失效，请重新登录！";

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
    public static final String VERIFICATION_CODE_NULL = "请先输入验证码";

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
    public static final String VERIFICATION_CODE_ERROR = "验证码错误";

    /**
     * 密码不符合规则
     */
    public static final String PASSWORD_NOT_RULE = "密码要同时包含数字和字母，并且长度要在6-16位之间！";

    /**
     * 邮箱绑定其他用户
     */
    public static final String EMAIL_OCCUPY = "邮箱绑定其他用户！";

    /**
     * 原密码不能为空
     */
    public static final String OLD_PASSWORD_NULL = "原密码不能为空！";

    /**
     * 新密码不能为空
     */
    public static final String NEW_PASSWORD_NULL = "新密码不能为空！";

    /**
     * 用户类型不能为空
     */
    public static final String USERNAME_TYPE_NULL = "用户类型不能为空！";

    /**
     * 用户信息有误
     */
    public static final String USER_ERROR = "用户信息有误！";

    /**
     * 用户不为企业用户，无法新建职位
     */
    public static final String POSITION_USER_NOT_COMPANY_USER = "用户不为企业用户，无法新建职位";

    /**
     * 没有修改权限
     */
    public static final String NOT_UPDATE_JURISDICTION = "没有修改权限";

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

    /**
     * 公司还在审核中！
     */
    public static final String EXAMINE = "公司还在审核中！";

}
