package com.algorithm.study.demo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xun2.liu
 * @title: DateUtils
 * @projectName algorithm-study
 * @description: TODO
 * @date 2019/8/30 11:14
 */
public class DateUtils {
    private static final String formatStr = "HH:mm";
    public static void main(String args[]) throws ParseException {
        String tS = "11:00";
        String tE = "12:10";
        System.out.println(getLong(tS));
        System.out.println(getLong(tE));
        System.out.println(getCurrentTime());
        System.out.println(isInZone(getLong(tS),getLong(tE),getCurrentTime()));
        if(isInZone(getLong(tS),getLong(tE),getCurrentTime())){
            System.out.println("当前时间在范围中");
        }else{
            System.out.println("当前时间不在范围中");
        }
    }

    private static boolean isInZone(long tStart,long tEnd,long t) throws ParseException {
        return t>=tStart && t<=tEnd;
    }

    private static long getLong(String timeStr) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(formatStr);
        return dateFormat.parse(timeStr).getTime();
    }

    private static long getCurrentTime() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(formatStr);
        return getLong(dateFormat.format(new Date()));
    }
}
