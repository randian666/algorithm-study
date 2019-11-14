package com.algorithm.study.demo;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * @description: JodaTime工具类
 * @date 2019/5/31 11:24
 **/
public class JodaTimeUtil {
    public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String STANDARD_DAY_FORMAT = "yyyy-MM-dd";
    public static final String STANDARD_DAY_FORMAT_1 = "yyyyMMdd";
    public static final String STANDARD_MILLIS_FORMAT="yyyy-MM-dd HH:mm:ss.SSS";
    public static final String STANDARD_MINUTE_FORMAT="yyyyMMddHHmm";

    public static Date strToDate(String dateTimeStr,String formatStr){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(formatStr);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }
    public static DateTime dateToDateTime(Date date){
        DateTime dateTime = new DateTime(date);
        return dateTime;
    }
    public static Date strToDate(String dateTimeStr){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(STANDARD_FORMAT);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }
    public static Date getNow(){
        return DateTime.now().toDate();
    }
    public static String getNowFormat(String formatStr){
        return DateTime.now().toString(formatStr);
    }
    public static String getFormatNow(){
        return DateTime.now().toString(STANDARD_DAY_FORMAT_1);
    }
    public static String getFormatNowDay(){
        return DateTime.now().toString(STANDARD_DAY_FORMAT);
    }

    public static Long strToMillis(String dateTimeStr,String formatStr){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(formatStr);
        long dateTime = dateTimeFormatter.parseDateTime(dateTimeStr).getMillis();
        return dateTime;
    }

    public static String dateToStr(Date date,String formatStr){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(formatStr);
    }
    public static String dateStrToMinuteStr(String dateTimeStr,String formatStr1,String formatStr2){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(formatStr1);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toString(formatStr2);
    }



    public static String dateToStr(Date date){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(STANDARD_FORMAT);
    }

    /**
     * 解析日期 yyyy-MM-dd HH:mm:ss
     *
     * @param timestamp
     * @return
     */
    public static String format(Long timestamp, String pattern) {
        String dateStr = "";
        if (null == timestamp || timestamp.longValue() < 0) {
            return dateStr;
        }
        try {
            Date date = new Date(timestamp);
            dateStr=dateToStr(date,pattern);
        } catch (Exception e) {
            // ignore
        }
        return dateStr;
    }
    public static DateTime strToDateTime(String dateTimeStr,String formatStr){
        Date date = strToDate(dateTimeStr, formatStr);
        return dateToDateTime(date);
    }

    public static void main(String[] args) {
        Date createTime = JodaTimeUtil.strToDate("2019-10-24 02:04:41.921", JodaTimeUtil.STANDARD_MILLIS_FORMAT);
        DateTime dateTime = dateToDateTime(createTime);
        System.out.println(dateTime.getHourOfDay());
    }
}
