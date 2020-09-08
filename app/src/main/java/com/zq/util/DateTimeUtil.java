package com.zq.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

@Slf4j
public class DateTimeUtil {

    /**
     * 输出指定日期的格式(null为默认格式)
     *
     * @param time 时间戳
     * @param type 格式,默认格式yyyy-MM-dd HH:mm:ss
     */
    public static String getStringByLong(Long time, String type) {
        if (StringUtils.isBlank(type)) {
            type = "yyyy-MM-dd HH:mm:ss";
        }
        LocalDateTime localDateTime = Instant.ofEpochMilli(time).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
        return localDateTime.format(DateTimeFormatter.ofPattern(type));
    }

    /**
     * 将时间的字符串转为date (null为默认格式)
     *
     * @param date 时间字符串
     * @param type 转换格式 默认格式yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static LocalDateTime getDateByString(String date, String type) {
        if (StringUtils.isBlank(type)) {
            type = "yyyy-MM-dd HH:mm:ss";
        }
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(type));
    }

    /**
     * 将Date 按格式 转为字符串 (null使用默认格式)
     * @param date
     * @param type 默认格式为 yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getStringByDate(LocalDateTime date, String type) {
        if (StringUtils.isBlank(type)) {
            type = "yyyy-MM-dd HH:mm:ss";
        }
        return date.format(DateTimeFormatter.ofPattern(type));
    }

    /**
     * 获取指定日期之前或之后的日期,并按格式返回
     *
     * @param date
     * @param dateNum 时间数量  之前为负数,之后为正数
     * @param unit    时间单位 请使用java.util.Calendar
     *                ,Calendar.MONTH表示月
     *                ,Calendar.DAY_OF_MONTH表示日
     *                ,如Calendar.HOUR_OF_DAY表示小时
     *                ,如Calendar.MINUTE表示分
     *                ,如Calendar.SECOND表示秒
     */
    public static LocalDateTime getAroundDateByUint(LocalDateTime date, int dateNum, ChronoUnit unit) {
        return date.plus(dateNum, unit);
    }

    /**
     * 获取所传时间的指定日期(不传为null)
     *
     * @param date   时间
     * @param month  月(0-11)
     * @param day    日(0-30)
     * @param hour   时(0-23)
     * @param minute 分(0-59)
     * @param second 秒(0-59)
     */
    public static LocalDateTime getDateByTime(LocalDateTime date, Integer month, Integer day, Integer hour, Integer minute, Integer second){

        if (month != null && month >= 1 && month <= 12) {
            date = date.withMonth(month);
        }
        if (day != null && day >= 1 && day <= 31) {
            date = date.withDayOfMonth(day);
        }
        if (hour != null && hour >= 0 && hour <= 23) {
            date = date.withHour(hour);
        }
        if (minute != null && minute >= 0 && minute <= 59) {
            date = date.withMinute(minute);
        }
        if (second != null && second >= 0 && second < 59) {
            date = date.withSecond(second);
        }
        return date;
    }

}
