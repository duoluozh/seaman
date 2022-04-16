package com.lhh.seamanrecruit.utils;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.util.Objects;
import java.util.Random;

/**
 * @Author: yslong
 * @Date: 2022/4/9 15:38
 * @Description: MD5工具类
 */
public class Md5Util {

    /**
     * MD5加密
     *
     * @param password 需要加密的数据
     * @return 加密后的数据
     */
    public static String generate(String password) {
        String salt = getSalt();
        password = md5Hex(password + salt);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = password.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        return new String(cs);
    }

    /**
     * 获取十六进制字符串形式的MD5摘要
     * @param src 数据
     * @return 十六进制字符串形式的MD5摘要
     */
    private static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(new Hex().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 校验加盐后是否和原文一致
     *
     * @param password 原密码
     * @param md5 加盐后的密码
     * @return 校验结构（true：一致，false：不一致）
     */
    public static boolean verify(String password, String md5) {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = md5.charAt(i);
            cs1[i / 3 * 2 + 1] = md5.charAt(i + 2);
            cs2[i / 3] = md5.charAt(i + 1);
        }
        String salt = new String(cs2);
        return Objects.equals(md5Hex(password + salt), new String(cs1));
    }

    /**
     * @Description 随机生成盐值
     * @return String 盐
     */
    public static String getSalt() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder(16);
        sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
        int len = sb.length();
        if (len < 16) {
            for (int i = 0; i < 16 - len; i++) {
                sb.append("0");
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String s = Md5Util.generate("zhouhui19991110");
        System.out.println(s);
        System.out.println(Md5Util.verify("zhouhui19991110", s));

    }


}
