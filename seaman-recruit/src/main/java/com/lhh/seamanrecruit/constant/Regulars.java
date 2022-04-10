package com.lhh.seamanrecruit.constant;

/**
 * @author zhh
 * @date 2022/4/11 1:05
 * @description 正则表达式常量类
 */
public class Regulars {

    /**
     * 密码正则表达式:由数字和字母组成，并且要同时含有数字和字母，且长度要在8-16位之间。
     */
    private final static String PASSWORD_REGULAR = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";

}
