package com.lhh.seamanrecruit.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/**
 * @Author: yslong
 * @Date: 2022/4/9 13:31
 * @Description: LocalDateTime工具类
 */
public class LocalDateTimeUtils {
    //获取当前时间的LocalDateTime对象
    //LocalDateTime.now();

    //根据年月日构建LocalDateTime
    //LocalDateTime.of();

    //比较日期先后
    //LocalDateTime.now().isBefore(),
    //LocalDateTime.now().isAfter(),

    /**
     * Date转换为LocalDateTime
     * @param date Date类型
     * @return LocalDateTime类型
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * LocalDateTime转换为Date
     * @param time LocalDateTime类型
     * @return Date类型
     */
    public static Date localDateTimeToDate(LocalDateTime time) {
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取指定日期的毫秒
     * @param time 指定时间
     * @return 指定日期的毫秒
     */
    public static Long getMilliByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 获取指定日期的秒
     * @param time 指定时间
     * @return 指定日期的秒
     */
    public static Long getSecondsByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    /**
     * 获取指定时间的指定格式
     * @param time 时间
     * @param pattern 需要转换的格式（yyyy-MM-dd HH:mm:ss）
     * @return 指定时间的指定格式
     */
    public static String formatTime(LocalDateTime time, String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 获取当前时间的指定格式
     * @param pattern 需要转换的格式（yyyy-MM-dd HH:mm:ss）
     * @return 当前时间的指定格式
     */
    public static String formatNow(String pattern) {
        return formatTime(LocalDateTime.now(), pattern);
    }

    /**
     * 日期加法   time（时间）+number（数值） field（单位：由ChronoUnit.*获取）
     * @param time 时间
     * @param number 数值
     * @param field 时间单位(年月日时分秒)
     * @return 运算结果
     */
    public static LocalDateTime plus(LocalDateTime time, long number, TemporalUnit field) {
        return time.plus(number, field);
    }

    /**
     * 日期减法 time（时间）-number（数值） field（单位：由ChronoUnit.*获取）
     * @param time 时间
     * @param number 数值
     * @param field 单位(年月日时分秒)
     * @return 运算结果
     */
    public static LocalDateTime minu(LocalDateTime time, long number, TemporalUnit field) {
        return time.minus(number, field);
    }

    /**
     * 获取两个日期的差  startTime（起始时间）-endTime（结束时间） field（单位：由ChronoUnit.*获取）
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param field 单位(年月日时分秒)
     * @return 运算结果
     */
    public static long betweenTwoTime(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field) {
        Period period = Period.between(LocalDate.from(startTime), LocalDate.from(endTime));
        if (field == ChronoUnit.YEARS) {
            return period.getYears();
        }
        if (field == ChronoUnit.MONTHS) {
            return period.getYears() * 12 + period.getMonths();
        }
        return field.between(startTime, endTime);
    }

    /**
     * 获取一天的开始时间，2017,7,22 00:00
     * @param time 日期
     * @return 一天的开始时间
     */
    public static LocalDateTime getDayStart(LocalDateTime time) {
        return time.withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);
    }

    /**
     * 获取一天的结束时间，2017,7,22 23:59:59.999999999
     * @param time 日期
     * @return 一天的结束时间
     */
    public static LocalDateTime getDayEnd(LocalDateTime time) {
        return time.withHour(23)
                .withMinute(59)
                .withSecond(59)
                .withNano(999999999);
    }
}
